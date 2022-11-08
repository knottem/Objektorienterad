package Sprint4.Uppgift3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.*;
import java.time.LocalTime;

public class ChatMultiCast {

    String ip = "234.235.236.237";
    String networkInterface = "eth5";
    int port = 23456;

    JFrame frame = new JFrame("Chat");
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JTextArea jTextArea = new JTextArea(20, 40);
    JTextField jTextField = new JTextField();
    JButton button = new JButton("Koppla ner");

    MulticastSocket socket;
    String username;

    private void startServices() {
        try {
            socket = new MulticastSocket(port);
            InetSocketAddress group = new InetSocketAddress(InetAddress.getByName(ip), port);
            NetworkInterface netIf = NetworkInterface.getByName(networkInterface);

            socket.joinGroup(group, netIf);
            new Thread(receiveMessages).start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessages(String message) {
        try {
            byte[] buffer = (message).getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), 23456);
            socket.send(packet);
            jTextField.setText("");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void getText(String message){
        if(message.startsWith("/nick")){
            String[] messageSplit = message.split(" ", 2);
            sendMessages(LocalTime.now().withNano(0) +": " + username + " changed nick to " + messageSplit[1]);
            username = messageSplit[1];
            frame.setTitle("Chat: " + username);
        }
        else {
            sendMessages(LocalTime.now().withNano(0) +": " + username + ": " + message);
        }
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private final Runnable receiveMessages = () -> {
        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetSocketAddress group = new InetSocketAddress(InetAddress.getByName(ip), port);
            NetworkInterface netIf = NetworkInterface.getByName(networkInterface);

            socket.joinGroup(group, netIf);
            byte[] data = new byte[256];
            while (true) {
                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                jTextArea.append(message + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public void setupWindow(String username){

        this.username = username;

        frame.setLayout(new BorderLayout());
        topPanel.add(button);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(jTextArea);
        JScrollPane scrollBar = new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollBar);
        bottomPanel.add(jTextField);
        bottomPanel.setLayout(new GridLayout(1,1));
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setTitle("Chat: " + username);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(e -> System.exit(0));

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