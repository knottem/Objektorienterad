package Sprint4.Uppgift6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    private static final ArrayList<Kompis> databas = new Databas().getDatabase();

    public boolean found;
    public String messageFromClient;

    public ClientHandler(Socket socket){
        try {
            this.socket = socket;
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            closeEverything(socket, bufferedReader,printWriter);
        }
    }

    @Override
    public void run() {
        while(socket.isConnected()){
            try{
                found = false;
                messageFromClient = bufferedReader.readLine();

                for (Kompis database : databas) {
                    if (messageFromClient.equalsIgnoreCase(database.getName())) {
                        printWriter.println(database);
                        found = true;
                    }
                }
                if (!(found)) {
                    printWriter.println("Personen hittades inte i telefonboken");
                }
            }catch (IOException e){
                closeEverything(socket, bufferedReader, printWriter);
                break;
            }
        }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, PrintWriter printWriter){
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
