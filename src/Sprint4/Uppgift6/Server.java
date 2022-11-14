package Sprint4.Uppgift6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    private static final int receivePort = 23456;
    private static final int sendPort = 23457;
    byte[] data = new byte[256];

    static Databas databas = new Databas();
    boolean found;

    static InetAddress ip;


    @SuppressWarnings("InfiniteLoopStatement")
    private void server() {
        try (DatagramSocket socket = new DatagramSocket(receivePort)){
                while (true) {
                    found = false;
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    socket.receive(packet);

                    ip = packet.getAddress();

                    String message = new String(packet.getData(), 0, packet.getLength());

                    for (int i = 0; i < databas.database.size(); i++) {
                        if (message.equalsIgnoreCase(databas.database.get(i).getName())) {
                            broadcast(databas.database.get(i).toString());
                            found = true;
                        }
                    }
                    if (!(found)) {
                        broadcast("Personen hittades inte i telefonboken");
                    }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void broadcast(String broadcastMessage) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(broadcastMessage.getBytes(), broadcastMessage.length(), ip, sendPort);
        socket.send(packet);
        socket.close();
        System.out.println("Message sent to: " + ip.getHostName());
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.server();

    }
}
