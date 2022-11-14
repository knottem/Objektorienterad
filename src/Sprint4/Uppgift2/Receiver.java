package Sprint4.Uppgift2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver {

    public static void main(String[] args) throws IOException {

        DatagramSocket recieveSocket = new DatagramSocket(45678);
        //DatagramSocket sendSocket = new DatagramSocket();
        byte[] data = new byte[256];
        while(true){
            DatagramPacket packet = new DatagramPacket(data, data.length);
            recieveSocket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);

            //TODO skicka kvittens
            /*
            String kvittens = "meddelande mottaget";
            byte[] kvittensBA = kvittens.getBytes();
            packet = new DatagramPacket(kvittensBA, kvittensBA.length, InetAddress.getByName("localhost"), 45679);
            sendSocket.send(packet);
            System.out.println("Kvittens skickat");

             */

        }
    }
}
