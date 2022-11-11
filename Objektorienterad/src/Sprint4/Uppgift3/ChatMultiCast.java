package Sprint4.Uppgift3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.*;
import java.time.LocalTime;

public class ChatMultiCast {

    private final String ip = "234.235.236.237";
    private final int port = 23456;
    private String username;

    JFrame frame = new JFrame("Chat");
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JTextArea jTextArea = new JTextArea(20, 40);
    JTextField jTextField = new JTextField();
    JButton button = new JButton("Connect");

    boolean quit = true;

    MulticastSocket socket;

    private void startServices() {
        try {
            socket = new MulticastSocket(port);
            InetSocketAddress group = new InetSocketAddress(InetAddress.getByName(ip), port);
            NetworkInterface netIf = NetworkInterface.getByName("wlan1");
            socket.joinGroup(group, netIf);
            new Thread(receiveMessages).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void sendMessages(String message) {
        if(!quit) {
            try {
                byte[] buffer = (LocalTime.now().withNano(0) + ": " + username + message).getBytes();
                socket.send(new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), port));
                jTextField.setText("");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void getText(String message){
        if(!quit) {
            if (message.startsWith("/nick")) {
                String[] messageSplit = message.split(" ", 2);
                sendMessages(" changed nick to " + messageSplit[1]);
                username = messageSplit[1];
                frame.setTitle("Chat: " + username);
            } else {
                sendMessages(": " + message);
            }
        }
    }

    private final Runnable receiveMessages = () -> {
            byte[] data = new byte[256];
        while(!quit) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            String message = new String(packet.getData(), 0, packet.getLength());
            jTextArea.append(message + "\n");
        }
    };

    public void setupWindow(String username){

        this.username = username;

        frame.setLayout(new BorderLayout());
        topPanel.add(button);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(jTextArea);
        JScrollPane scrollPane = new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);
        bottomPanel.add(jTextField);
        bottomPanel.setLayout(new GridLayout(1,1));
        frame.add(bottomPanel, BorderLayout.SOUTH);
        jTextArea.setEditable(false);

        frame.setTitle("Chat: " + username);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(e -> {
            if(!quit){
                sendMessages(" lämnade chatten.");
                quit = true;
                socket.close();
                button.setText("Connect");
            }
            else {
                startServices();
                quit = false;
                sendMessages(" joined chat");
                button.setText("Disconnect");
            }

        });


        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    getText(jTextField.getText());
                }
            }
        });


    }

    public static void main(String[] args) {
        ChatMultiCast chatMultiCast = new ChatMultiCast();
        String name = JOptionPane.showInputDialog("Ange ditt namn");
        chatMultiCast.setupWindow(name);
        chatMultiCast.startServices();
    }
}