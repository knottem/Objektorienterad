package Sprint4.Uppgift5TCP;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandlerV2 implements Runnable{

    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;
    private static final ArrayList<Kompis> databas = new Databas().getDatabase();
    private static final Databas data = new Databas();

    public boolean found;
    public String messageFromClient;

    public ClientHandlerV2(Socket socket){
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
                printWriter.println("\nVilken person vill du söka efter:");
                printWriter.println("'email =' för att söka med email.");
                printWriter.println("'tfnr =' för att söka med telefonnummer");
                messageFromClient = bufferedReader.readLine();


                if(messageFromClient.startsWith("email =")){
                    for (Kompis database : databas){
                        String[] messageSplit = messageFromClient.split(" =", 2);
                        if(messageSplit[1].trim().equalsIgnoreCase(database.getEmail())){
                            printWriter.println(database);
                            found = true;
                        }
                    }
                } else if (messageFromClient.startsWith("tfnr =")) {
                    for (Kompis database : databas){
                        String[] messageSplit = messageFromClient.split(" =", 2);
                        if(messageSplit[1].trim().equalsIgnoreCase(String.valueOf(database.getPhoneNumber()))){
                            printWriter.println(database);
                            found = true;
                        }
                    }
                } else {
                    for (Kompis database : databas) {
                        if (messageFromClient.equalsIgnoreCase(database.getName())) {
                            printWriter.println(database);
                            found = true;
                        }
                    }

                    //printWriter.println(data.getName(messageFromClient));
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
