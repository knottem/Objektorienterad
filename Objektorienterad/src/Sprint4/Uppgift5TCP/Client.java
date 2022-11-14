package Sprint4.Uppgift5TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    boolean wait;

    public Client(Socket socket) {
        try {
            Client.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }


    void client(){
        while(true){
            if(!wait) {
                Scanner scan = new Scanner(System.in);
                System.out.println("\nVilken person vill du söka efter:");
                String input = scan.nextLine();
                if (input.equals("exit")) {
                    break;
                } else {
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
           closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }

    public void listenForMessage(){
        new Thread(() -> {
            String msgFromServer;
            while(socket.isConnected()){
                try{
                    msgFromServer = bufferedReader.readLine();
                    System.out.println(msgFromServer);
                    wait = false;

                }catch (IOException e){
                    closeEverything(socket,bufferedReader,bufferedWriter);
                }
            }
        }).start();
    }

    public static void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if(bufferedReader != null){
                bufferedReader.close();
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
    }



    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",12345);
        Client client = new Client(socket);
        client.listenForMessage();
        client.client();


    }
}
