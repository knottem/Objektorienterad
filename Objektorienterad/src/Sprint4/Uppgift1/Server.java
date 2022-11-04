package Sprint4.Uppgift1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


        public Server(){

        int counter = 0;
        int portNumber = 12345;

        try (ServerSocket serverSocket = new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true))
        {
            while (true) {
               out.println("Counting: " + counter);
               counter++;
               Thread.sleep(1000);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Server();
    }

}
