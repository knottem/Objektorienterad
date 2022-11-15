package Sprint4.Uppgift7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    private Socket socket;
    private BufferedReader bufferedReader;
    private ObjectOutputStream objectOutputStream;
    private static final ArrayList<Kompis> databas = new Databas().getDatabase();

    public boolean found = true;
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
                if(found){
                    objectOutputStream.writeObject(new Initiator());
                }
                found = false;

                objectOutputStream.writeObject(new Response("\nVilken person vill du söka efter:"));
                objectOutputStream.writeObject(new Response("'email =' för att söka med email."));
                objectOutputStream.writeObject(new Response("'tfnr =' för att söka med telefonnummer"));

                messageFromClient = bufferedReader.readLine();


                if (messageFromClient.startsWith("email =")) {
                    for (Kompis database : databas) {
                        String[] messageSplit = messageFromClient.split(" =", 2);
                        if (messageSplit[1].trim().equalsIgnoreCase(database.getEmail())) {
                            objectOutputStream.writeObject(new Response(true, database));
                            objectOutputStream.flush();
                            found = true;
                        }
                    }
                } else if (messageFromClient.startsWith("tfnr =")) {
                    try {
                        for (Kompis database : databas) {
                            String[] messageSplit = messageFromClient.split(" =", 2);
                            if (messageSplit[1].trim().equalsIgnoreCase(database.getPhoneNumber())) {
                                objectOutputStream.writeObject(new Response(true, database));
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
                            objectOutputStream.writeObject(new Response(true,database));
                            objectOutputStream.flush();
                            found = true;
                        }
                    }
                }
                if (!(found)) {
                    objectOutputStream.writeObject(new Response(false));

                }
                found = false;
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
