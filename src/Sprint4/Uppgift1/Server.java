package Sprint4.Uppgift1;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final ServerSocket serverSocket;
    int counter = 0;
    int counter2 = 1;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    public void serverStart(){
        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                counter++;
                System.out.println("A new client has connected\nThis was client number " + counter);
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("You are client number " + counter);
                do {
                    printWriter.println("Hello " + counter2);
                    counter2++;
                    Thread.sleep(1000);
                } while (counter2 <= 10);
                counter2 = 1;
                socket.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(43001);
        Server server = new Server(serverSocket);
        server.serverStart();
    }

}
