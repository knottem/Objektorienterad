package Sprint4.Uppgift4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Sensor {

    private void send() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilken stad?");
        String city = scan.nextLine();
        System.out.println("Vilken tempereratur?");
        String temp = scan.nextLine();

        DatagramSocket datagramSocket = new DatagramSocket();

        while(city != null || temp != null){
            String message = city + temp;
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName(adress), 45678);
            datagramSocket.send(packet);
            city = null;
            temp = null;
        }
    }


    public static void main(String[] args) throws IOException {
        Sensor sensors = new Sensor();
        sensors.send();
    }
}
