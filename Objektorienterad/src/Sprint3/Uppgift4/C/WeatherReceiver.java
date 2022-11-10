package Sprint3.Uppgift4.C;

import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Objects;

public class WeatherReceiver {

    static ArrayList<String> city = new ArrayList<>();
    static ArrayList<String> temp = new ArrayList<>();
    JFrame frame = new JFrame("Väder");
    JTextArea textArea = new JTextArea(20,25);

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
            String ip = "234.235.236.237";
            InetSocketAddress group = new InetSocketAddress(InetAddress.getByName(ip), 23456);
            NetworkInterface netIf = NetworkInterface.getByName("eth5");

            socket.joinGroup(group, netIf);

            while (true) {
                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                String[] messageSplit = message.split(" ", 2);

                if(messageSplit.length == 2) {
                    System.out.println("Temperatur för staden " + messageSplit[0].toLowerCase() + " : " + messageSplit[1]);
                }
                boolean newCity = true;
                if(messageSplit.length == 2) {
                    for (int i = 0; i < city.size(); i++) {
                        if (Objects.equals(city.get(i), messageSplit[0].toLowerCase())) {
                            temp.set(i,messageSplit[1]);
                            newCity = false;
                        }
                    }
                }
                if(newCity){
                    city.add(messageSplit[0].toLowerCase());
                    temp.add(messageSplit[1]);
                }

                //Rewrites all text to textArea
                textArea.setText("");
                for (int i = 0; i <city.size(); i++) {
                    textArea.append("Temperatur för staden: " + city.get(i) + " är " + temp.get(i) + "\n");
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
