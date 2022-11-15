package Sprint4.Uppgift1;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

    String hostName = "localhost";

    void ClientTest() {
        while (true) {
            try (Socket socket = new Socket(hostName, 43001);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

                String fromServer;
                while ((fromServer = bufferedReader.readLine()) != null) {
                    System.out.println(fromServer);
                }
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to " + hostName);
                break;
            }
        }
    }

    public static void main(String[] args){
        new Client().ClientTest();
    }
}