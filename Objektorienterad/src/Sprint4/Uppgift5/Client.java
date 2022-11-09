package Sprint4.Uppgift5;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    private static final String ip = "localhost";
    private static final int receivePort = 23457;
    private static final int sendPort = 23456;
    static byte[] data = new byte[256];


    void client(){
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
            receiveBroadcast();
        }
    }

    public static void broadcast(String broadcastMessage) {
        try(DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket packet = new DatagramPacket(broadcastMessage.getBytes(), broadcastMessage.length(), InetAddress.getByName(ip), sendPort);
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void receiveBroadcast(){
        try(DatagramSocket socket = new DatagramSocket(receivePort)) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args){
        Client client = new Client();
        client.client();
    }
}
