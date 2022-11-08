package Sprint4.Uppgift2;

import java.io.IOException;
import java.net.*;
import java.time.LocalTime;

public class Sender {

    public void sendQuote() throws IOException, InterruptedException {

        DatagramSocket datagramSocket = new DatagramSocket();
        String[] quotes = {"Solen är gul", "Havet är blått", "Det är mörkt på natten"};
        String adress = "localhost";
        while (true) {
            for (int i = 0; i < quotes.length; i++) {
                String message = quotes[i] + " " + LocalTime.now().withNano(0);
                byte[] data = message.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName(adress), 45678);
                datagramSocket.send(packet);
                Thread.sleep(5000);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Sender sender = new Sender();
        sender.sendQuote();
    }
}
