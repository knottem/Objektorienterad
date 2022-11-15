package Sprint4.Demo.DemoTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    int port = 44446;
    String ack = "message received: ";
    String welcomeMessage = "Welcome to the Server";

    public Server() throws IOException {

        try(ServerSocket servS = new ServerSocket(port);
            Socket socket = servS.accept();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            printWriter.println(welcomeMessage);

            String temp = "";
            while((temp =in.readLine())!=null){
                System.out.println(temp);
                printWriter.println(ack + temp);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}

