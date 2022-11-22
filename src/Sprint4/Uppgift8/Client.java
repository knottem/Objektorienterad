package Sprint4.Uppgift8;

import Sprint4.Uppgift8.Server.Initiator;
import Sprint4.Uppgift8.resources.Response;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {

    private static final String ip = "localhost";
    private static final int port = 12345;

    private static Socket socket;
    private static ObjectInputStream objectInputStream;
    private static BufferedWriter bufferedWriter;

    private static String serverName;


    boolean wait;

    public Client(Socket socket) {
        try {
            Client.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            serverName = socket.getInetAddress().getHostName();
        }catch (IOException e){
            closeEverything(socket,objectInputStream,bufferedWriter);
        }
    }


    void client(){
        while(true){
            if(!wait) {
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                if (input.contains("exit")) {
                    System.out.println("Disconnected");
                    System.exit(0);
                    break;
                }
                else {
                    broadcast(input);
                    wait = true;
                }
            }
        }
    }

    public static void broadcast(String broadcastMessage) {
        try{
            bufferedWriter.write(broadcastMessage);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
           closeEverything(socket, objectInputStream, bufferedWriter);
        }

    }

    public void listenForMessage(){
        new Thread(() -> {
            try{
                Object fromServer;
                while ((fromServer = objectInputStream.readObject()) != null) {
                    if(fromServer instanceof String) {
                        System.out.println(fromServer);
                        wait = false;
                    } else if (fromServer instanceof Integer){
                        int test = (int) fromServer;
                        System.out.println(test);
                        wait = false;
                    } else if (fromServer instanceof Initiator initiator) {
                        System.out.println(initiator.welcomeMessage());
                        wait = false;
                    } else if (fromServer instanceof Response response) {
                        if(!(response.getSuccess())) {
                            System.out.println("Personen hittades inte med sök: " + response.getString());
                        } else {
                            System.out.println(response.getKompis());
                        }
                        wait = false;
                    }
                }
            }catch (SocketException e){
                closeEverything(socket,objectInputStream,bufferedWriter);
            }catch (ClassNotFoundException | IOException e) {
                System.out.println("Klassen hittades inte");
            }
        }).start();
    }
    public static void closeEverything(Socket socket, ObjectInputStream objectInputStream, BufferedWriter bufferedWriter){
        try{
            if(objectInputStream != null){
                objectInputStream.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("\nLost connection to server: " + serverName);
        System.exit(0);
    }



    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ip,port);
        Client client = new Client(socket);
        client.listenForMessage();
        client.client();


    }
}
