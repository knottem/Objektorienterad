package Sprint4.Uppgift4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class WeatherServer {

    public static void main(String[] args) throws IOException {
        int minPort = 45678;
        DatagramSocket socket = new DatagramSocket(minPort);
        byte[] data = new byte[256];
        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);
            }
        }
    }
