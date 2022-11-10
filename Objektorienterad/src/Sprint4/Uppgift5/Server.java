package Sprint4.Uppgift5;

import java.io.IOException;
import java.net.*;

public class Server {

    private static final int receivePort = 23456;
    private static final int sendPort = 23457;
    byte[] data = new byte[256];

    static Databas databas = new Databas();
    boolean found;

    private static InetAddress ip;
    private static DatagramSocket socket;

    @SuppressWarnings("InfiniteLoopStatement")
    private void server() {
        try {
            socket = new DatagramSocket(receivePort);
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
        DatagramPacket packet = new DatagramPacket(broadcastMessage.getBytes(), broadcastMessage.length(), ip, sendPort);
        socket.send(packet);
        System.out.println("Message sent to: " + ip.getHostName());
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.server();

    }
}
