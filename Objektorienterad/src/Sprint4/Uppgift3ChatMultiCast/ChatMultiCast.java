package Sprint4.Uppgift3ChatMultiCast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.*;
import java.time.LocalTime;

public class ChatMultiCast {

    private String ip = "234.235.236.237";
    private String net = "wlan1";
    private int port = 23456;
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
            NetworkInterface netIf = NetworkInterface.getByName(net);
            socket.joinGroup(group, netIf);
            new Thread(receiveMessages).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final Runnable receiveMessages = () -> {
        byte[] data = new byte[256];
        String message;
        while(!quit) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            message = new String(packet.getData(), 0, packet.getLength());
            jTextArea.append(message + "\n");
        }
    };

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
        if(quit){
            if(message.startsWith("/ip")){
                swapIp();
            }
            else if(message.startsWith("/nick")){
                String[] messageSplit = message.split(" ", 2);
                if(messageSplit.length == 2){
                    username = messageSplit[1];
                    frame.setTitle("Chat: " + username);
                }
                else{
                    jTextArea.append("Can't just use /nick needs a username also\n");
                }
            }
        }
        if(!quit) {
            if (message.startsWith("/nick")) {
                String[] messageSplit = message.split(" ", 2);
                if(messageSplit.length == 2) {
                    sendMessages(" changed nick to " + messageSplit[1]);
                    username = messageSplit[1];
                    frame.setTitle("Chat: " + username);
                }
                else {
                    jTextArea.append("Can't just use /nick needs a username also\n");
                }
            } else if (message.startsWith("/font")) {
                String[] messageSplit = message.split(" ", 2);
                try{
                    jTextArea.setFont(new Font(messageSplit[1],Font.PLAIN,12));
                    jTextField.setText("");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (message.startsWith("/help")) {
                jTextArea.append("HELP\n/nick to change your nickname\n/font to change font\n");
                jTextField.setText("");
            } else if(!message.isEmpty()) {
                sendMessages(": " + message);
            }
        }
    }

    private void swapIp(){
        if(quit){
            ip = JOptionPane.showInputDialog("Vilket ip vill du använda?");
            net = JOptionPane.showInputDialog("Vilket net interface? t.ex. wlan1");
            port = Integer.parseInt(JOptionPane.showInputDialog("Vilken port?"));
        }
    }

    private void buttonFunction(){
        if(!quit){
            sendMessages(" lämnade chatten.");
            quit = true;
            socket.close();
            button.setText("Connect");
        }
        else {
            quit = false;
            startServices();
            sendMessages(" joined chat");
            button.setText("Disconnect");
        }
    }
    public void setupWindow(String username){

        this.username = username;

        topPanel.add(button);

        JScrollPane scrollPane = new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jTextArea.setEditable(false);
        bottomPanel.add(jTextField);
        bottomPanel.setLayout(new GridLayout(1,1));

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(jTextArea);

        frame.setTitle("Chat: " + username);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(e -> buttonFunction());
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
    }
}