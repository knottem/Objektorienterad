package Sprint4.Uppgift5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    private static final String ip = "localhost";
    private static final int receivePort = 23457;
    private static final int sendPort = 23456;
    byte[] data = new byte[256];


    void client() throws IOException {
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Vilken person vill du söka efter:");
            String input = scan.nextLine();
            if(input.equals("exit")){
                break;
            }
            else{
                broadcast(input);
            }
            try (DatagramSocket socket = new DatagramSocket(receivePort)) {
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    socket.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());
                    System.out.println(message);
            }
        }



    }

    public static void broadcast(String broadcastMessage) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(broadcastMessage.getBytes(), broadcastMessage.length(), InetAddress.getByName(ip), sendPort);
        socket.send(packet);
        socket.close();
    }



    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.client();
    }
}
