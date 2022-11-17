package Sprint4.Uppgift8.Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable{

    private Socket socket;
    private BufferedReader bufferedReader;
    private ObjectOutputStream objectOutputStream;

    public String messageFromClient;

    Protocol protocol = new Protocol();

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
                objectOutputStream.writeObject(protocol.processInput(null));
                messageFromClient = bufferedReader.readLine();
                objectOutputStream.writeObject(protocol.processInput(messageFromClient));
            }catch (SocketException e){
                System.out.println("Client " + socket.getInetAddress().getHostName() + " disconnected");
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
