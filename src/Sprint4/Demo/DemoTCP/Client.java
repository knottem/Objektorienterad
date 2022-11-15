package Sprint4.Demo.DemoTCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    int port = 44446;
    String message = "hello";

    public Client() throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("localhost");
        try(Socket socket = new Socket(ip, port);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            String fromServer;

            while(true) {
                printWriter.println(message);
                fromServer = in.readLine();
                System.out.println(fromServer);
                Thread.sleep(3000);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws UnknownHostException {
        Client c = new Client();
    }
}
