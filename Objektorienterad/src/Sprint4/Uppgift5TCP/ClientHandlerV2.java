package Sprint4.Uppgift5TCP;

import java.io.*;
import java.net.Socket;

public class ClientHandlerV2 implements Runnable{

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    static Databas databas = new Databas();
    boolean found;

    public ClientHandlerV2(Socket socket){
        try {
            this.socket = socket;
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (Exception e) {
            closeEverything(socket, bufferedReader,printWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        while(socket.isConnected()){
            try{
                found = false;
                messageFromClient = bufferedReader.readLine();

                for (int i = 0; i < databas.database.size(); i++) {
                    if (messageFromClient.equalsIgnoreCase(databas.database.get(i).getName())) {
                        printWriter.println(databas.database.get(i).toString());
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
