package Sprint4.Uppgift12ChatTCP;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private String clientUsername;

    public ClientHandler(Socket socket){
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            this.clientUsername = bufferedReader.readLine();
            clientHandlers.add(this);
            broadcastMessage("SERVER: "+ clientUsername + " has entered the chat!");

        } catch (Exception e) {
            closeEverything(socket, bufferedReader,printWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        while(socket.isConnected()){
            try{
                messageFromClient = bufferedReader.readLine();
                if(messageFromClient.startsWith("/nick")){
                    String[] messageSplit = messageFromClient.split(" ", 2);
                    if(messageSplit.length == 2){
                        broadcastMessage(clientUsername + " renamed themselves to " + messageSplit[1].trim());
                        System.out.println(clientUsername + " renamed themselves to " + messageSplit[1].trim());
                        clientUsername = messageSplit[1].trim();
                    }
                } else if(messageFromClient.startsWith("/quit")){
                    System.out.println(clientUsername + " has left the chat!");
                    closeEverything(socket,bufferedReader,printWriter);
                    break;
                } else if(messageFromClient.startsWith("/msg")){
                    String[] messageSplit = messageFromClient.split(" ", 2);
                    if(messageSplit.length == 2){
                        broadcastMessage(clientUsername + ": " + messageSplit[1]);
                    }
                } else {
                    broadcastMessage(clientUsername +": "+ messageFromClient);
                }
            } catch (IOException e){
                closeEverything(socket, bufferedReader, printWriter);
                break;
            }
        }
    }

    public void broadcastMessage(String messageToSend){
        for(ClientHandler clientHandler : clientHandlers){
            try{
                clientHandler.printWriter.println(LocalTime.now().withNano(0) + ": " + messageToSend);
            }catch (Exception e){
                closeEverything(socket,bufferedReader,printWriter);
            }
        }
    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUsername + " has left the chat!");
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, PrintWriter printWriter){
        removeClientHandler();
        try{
            if(bufferedReader != null){
                bufferedReader.close();
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
    }
}
