package Sprint4.Uppgift1;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

    String hostName = "localhost";

    void ClientTest() throws IOException {
        try{
        Socket socket = new Socket(hostName, 12345);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String fromServer;
        while ((fromServer = bufferedReader.readLine()) != null) {
            System.out.println(fromServer);
            }
        }
        catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        //new Client().ClientTest();
    }
}