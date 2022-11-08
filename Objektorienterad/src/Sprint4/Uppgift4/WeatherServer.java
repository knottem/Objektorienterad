package Sprint4.Uppgift4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class WeatherServer {

    static ArrayList<String> city = new ArrayList<>();
    static ArrayList<String> temp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (DatagramSocket socket = new DatagramSocket(23456)) {
            byte[] data = new byte[256];
            while (true) {

                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                String[] messageSplit = message.split(" ", 2);

                if(messageSplit.length == 2) {
                    city.add(messageSplit[0]);
                    temp.add(messageSplit[1]);
                    System.out.println("Temperatur för staden " + messageSplit[0] + " : " + messageSplit[1]);
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
        }
    }
}
