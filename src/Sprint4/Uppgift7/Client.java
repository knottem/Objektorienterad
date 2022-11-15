package Sprint4.Uppgift7;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String ip = "localhost";
    private static final int port = 12345;

    private static Socket socket;
    private static ObjectInputStream objectInputStream;
    private static PrintWriter printWriter;


    boolean wait;

    public Client(Socket socket) {
        try {
            Client.socket = socket;
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        }catch (IOException e){
            closeEverything(socket,objectInputStream,printWriter);
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
                    printWriter.println(input);
                    wait = true;
                }
            }
        }
    }


    public void listenForMessage(){
        new Thread(() -> {
            try{
                Object kompis;
                while ((kompis = objectInputStream.readObject()) != null) {

                    if (kompis instanceof Initiator) {
                        System.out.println(((Initiator) kompis).WelcomeMessage() + socket.getInetAddress().getHostName());
                        wait = false;
                    } else if (kompis instanceof Response) {
                        if(!(((Response) kompis).getText() == null)){
                            System.out.println(((Response) kompis).getText());
                            wait = false;
                        } else if (!((Response) kompis).getSuccess()) {
                            System.out.println("Personen finns inte i databasen");
                            wait = false;
                        }  else {
                            System.out.println(((Response) kompis).getPerson());
                            wait = false;
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
                closeEverything(socket,objectInputStream,printWriter);
            }catch (ClassNotFoundException e) {
                System.out.println("Klassen hittades inte");
            }
        }).start();
    }
    public static void closeEverything(Socket socket, ObjectInputStream objectInputStream, PrintWriter printWriter){
        try{
            if(objectInputStream != null){
                objectInputStream.close();
            }
            if(printWriter != null){
                printWriter.close();
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
