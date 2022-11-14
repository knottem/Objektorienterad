package Sprint4.Uppgift5TCP;

import java.io.IOException;
import java.net.*;

public class Server {

    private static final int port = 12345;

    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer(){

        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected: " + socket.getInetAddress().getHostName());

                //ClientHandler clientHandler = new ClientHandler(socket);
                ClientHandlerV2 clientHandler = new ClientHandlerV2(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Server server = new Server(serverSocket);
        server.startServer();
    }

}
