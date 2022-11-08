package Sprint4.Uppgift4.b;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;

public class Sensor {

    JFrame frame = new JFrame("Sensor Program;");
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel cityLabel = new JLabel("Stad:");
    JLabel tempLabel = new JLabel("Temperatur:");
    JTextField cityText = new JTextField();
    JTextField tempText = new JTextField();
    JButton button = new JButton("Skicka");

    private void send() {

            button.addActionListener(e -> {
                String city = cityText.getText();
                String temp = tempText.getText();
                try (DatagramSocket datagramSocket = new DatagramSocket()) {
                    String message = city + " " + temp;
                    byte[] data = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("224.0.0.1"), 23456);
                    try {
                        datagramSocket.send(packet);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } catch (SocketException | UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }
            });
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

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.pack();
    }



    public static void main(String[] args) throws IOException {
        Sensor sensors = new Sensor();
        sensors.setUpWindow();
        sensors.send();
    }
}
