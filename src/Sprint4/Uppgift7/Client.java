package Sprint4.Uppgift7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String ip = "localhost";
    private static final int port = 12345;

    private static Socket socket;
    private static ObjectInputStream objectInputStream;
    private static BufferedWriter bufferedWriter;


    boolean wait;

    public Client(Socket socket) {
        try {
            Client.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            objectInputStream = new ObjectInputStream(socket.getInputStream());
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
                Object kompis;
                while ((kompis = objectInputStream.readObject()) != null) {

                    if (kompis instanceof Initiator) {
                        System.out.println(((Initiator) kompis).WelcomeMessage() + socket.getInetAddress().getHostName());
                    } else if (kompis instanceof Response) {
                        if(!(((Response) kompis).getText() == null)){
                            System.out.println(((Response) kompis).getText());
                        } else if (!((Response) kompis).getSuccess()) {
                            System.out.println("Personen finns inte i databasen");
                        }  else {
                            System.out.println(((Response) kompis).getPerson());
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
                closeEverything(socket,objectInputStream,bufferedWriter);
            }catch (ClassNotFoundException e) {
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
        System.out.println("\ndisconnected");
        System.exit(0);
    }



    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ip,port);
        Client client = new Client(socket);
        client.listenForMessage();
        client.client();


    }
}
