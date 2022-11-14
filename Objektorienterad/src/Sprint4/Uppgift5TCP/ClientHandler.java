package Sprint4.Uppgift5TCP;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    static Databas databas = new Databas();
    boolean found;

    public ClientHandler(Socket socket){
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (Exception e) {
            closeEverything(socket, bufferedReader,bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        while(socket.isConnected()){
            try{
                messageFromClient = bufferedReader.readLine();

                for (int i = 0; i < databas.database.size(); i++) {
                    if (messageFromClient.equalsIgnoreCase(databas.database.get(i).getName())) {
                        broadcastMessage(databas.database.get(i).toString());
                        found = true;
                    }
                }
                if (!(found)) {
                    broadcastMessage("Personen hittades inte i telefonboken");
                }
            }catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void broadcastMessage(String messageToSend){
            try{
                    bufferedWriter.write(messageToSend);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
            }catch (IOException e){
                closeEverything(socket,bufferedReader,bufferedWriter);
            }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
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
}