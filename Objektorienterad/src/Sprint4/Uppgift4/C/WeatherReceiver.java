package Sprint4.Uppgift4.C;

import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class WeatherReceiver {

    static ArrayList<String> city = new ArrayList<>();
    static ArrayList<String> temp = new ArrayList<>();
    JFrame frame = new JFrame("Väder");
    JTextArea textArea = new JTextArea(20,20);

    private void setupWindow(){
        frame.add(textArea);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void server() {
        byte[] data = new byte[256];
        try (MulticastSocket socket = new MulticastSocket(23456)){
            while (true) {
                String ip = "234.235.236.237";
                InetSocketAddress group = new InetSocketAddress(InetAddress.getByName(ip), 23456);
                NetworkInterface netIf = NetworkInterface.getByName("eth5");

                socket.joinGroup(group, netIf);

                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                String[] messageSplit = message.split(" ", 2);

                if(messageSplit.length == 2) {
                    city.add(messageSplit[0]);
                    temp.add(messageSplit[1]);
                    System.out.println("Temperatur för staden " + messageSplit[0] + " : " + messageSplit[1]);
                    textArea.append("Temperatur för staden " + messageSplit[0] + " : " + messageSplit[1] + "\n");
                }
                else{
                    System.out.println(message);
                }

                if (city.size() == 3) {
                    for (int i = 0; i < city.size(); i++) {
                        System.out.println(city.get(i) + " " + temp.get(i) + " Grader");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
       WeatherReceiver weatherServer = new WeatherReceiver();
       weatherServer.setupWindow();
       weatherServer.server();
    }
}
