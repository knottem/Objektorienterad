package Sprint4.Uppgift6;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    private Socket socket;
    private BufferedReader bufferedReader;
    private ObjectOutputStream objectOutputStream;
    private static final ArrayList<Kompis> databas = new Databas().getDatabase();

    public boolean found;
    public String messageFromClient;

    public ClientHandler(Socket socket){
        try {
            this.socket = socket;
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            closeEverything(socket, bufferedReader, objectOutputStream);
        }
    }

    @Override
    public void run() {
        while(socket.isConnected()){
            try {
                found = false;
                objectOutputStream.writeObject(new Kompis("\nVilken person vill du söka efter:", null, null, null));
                objectOutputStream.writeObject(new Kompis("'email =' för att söka med email.", null, null, null));
                objectOutputStream.writeObject(new Kompis("'tfnr =' för att söka med telefonnummer", null, null, null));

                messageFromClient = bufferedReader.readLine();


                if (messageFromClient.startsWith("email =")) {
                    for (Kompis database : databas) {
                        String[] messageSplit = messageFromClient.split(" =", 2);
                        if (messageSplit[1].trim().equalsIgnoreCase(database.getEmail())) {
                            objectOutputStream.writeObject(database);
                            objectOutputStream.flush();
                            found = true;
                        }
                    }
                } else if (messageFromClient.startsWith("tfnr =")) {
                    try {
                        for (Kompis database : databas) {
                            String[] messageSplit = messageFromClient.split(" =", 2);
                            if (messageSplit[1].trim().equalsIgnoreCase(database.getPhoneNumber())) {
                                objectOutputStream.writeObject(database);
                                objectOutputStream.flush();
                                found = true;
                            }
                        }
                    } catch (NumberFormatException e) {
                        objectOutputStream.write("Endast siffror till ett meddelande".getBytes());
                        found = true;
                    }
                } else {
                    for (Kompis database : databas) {
                        if (messageFromClient.equalsIgnoreCase(database.getName())) {
                            objectOutputStream.writeObject(database);
                            objectOutputStream.flush();
                            found = true;
                        }
                    }
                }
                if (!(found)) {
                    objectOutputStream.write("Personen hittades inte i telefonboken".getBytes());
                    objectOutputStream.flush();
                }
            }catch (SocketException e){
                System.out.println("Client disconnected: " + socket.getInetAddress().getHostName());
                closeEverything(socket, bufferedReader, objectOutputStream);
                break;
            }catch (IOException e){
                e.printStackTrace();
                closeEverything(socket, bufferedReader, objectOutputStream);
                break;
            }
        }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, ObjectOutputStream objectOutputStream){
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(objectOutputStream != null){
                objectOutputStream.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
