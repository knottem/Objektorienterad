package Sprint4.Uppgift4.C;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class Sensor implements ActionListener{

    JFrame frame = new JFrame("Sensor Program;");
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel cityLabel = new JLabel("Stad:");
    JLabel tempLabel = new JLabel("Temperatur:");
    JTextField cityText = new JTextField();
    JTextField tempText = new JTextField();
    JButton button = new JButton("Skicka");

    public static void broadcast(String broadcastMessage) throws IOException {
        String ip = "234.235.236.237";
        MulticastSocket socket = new MulticastSocket();

        byte[] buffer = broadcastMessage.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length,InetAddress.getByName(ip),23456);
        socket.send(packet);
        socket.close();
    }

    public void setUpWindow(){

        topPanel.add(cityLabel);
        topPanel.add(cityText);
        topPanel.setLayout(new GridLayout(1,1));

        bottomPanel.add(tempLabel);
        bottomPanel.add(tempText);
        bottomPanel.setLayout(new GridLayout(1,1));

        frame.setLayout(new GridLayout(3,1));
        frame.add(topPanel, 0);
        frame.add(bottomPanel,1);
        frame.add(button,2);
        button.addActionListener(this);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setSize(300,150);
    }



    public static void main(String[] args) throws IOException {
        Sensor sensors = new Sensor();
        sensors.setUpWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            String city = cityText.getText();
            String temp = tempText.getText();
            String message = city + " " + temp;
            try {
                broadcast(message);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
