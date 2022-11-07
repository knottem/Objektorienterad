package Sprint4.Uppgift3;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;


public class Client {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;
    private final JFrame frame = new JFrame();
    private final JPanel topPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel();
    private static final JButton button = new JButton("Koppla ner");
    private final JTextArea jTextArea = new JTextArea(20,40);
    private final JTextField jTextField = new JTextField();
    private String messageToSend;

    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        }catch (IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }


    public void sendMessage(){
        try{
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            while(socket.isConnected()){

                jTextField.addActionListener(e -> {
                    if(!(jTextField.getText().equals(""))) {
                        messageToSend = jTextField.getText();
                        jTextField.setText("");
                    }
                });
                if(messageToSend != null){
                    bufferedWriter.write(username + ": " + messageToSend);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    messageToSend = null;
                }
            }
        }catch (IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }

    public void listenForMessage(){
        new Thread(() -> {
            String msgFromGroupChat;

            while(socket.isConnected()){
                try{
                    msgFromGroupChat = bufferedReader.readLine();
                    jTextArea.append(msgFromGroupChat + "\n");

                }catch (IOException e){
                    closeEverything(socket,bufferedReader,bufferedWriter);
                }
            }
        }).start();
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

    public void setupWindow(String username){

        frame.setTitle("Chat: " + username);
        frame.setLayout(new BorderLayout());
        topPanel.add(button);
        button.addActionListener(e -> System.exit(0));
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(jTextArea);
        bottomPanel.add(jTextField);
        bottomPanel.setLayout(new GridLayout(1,1));
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();


    }

    public static void main(String[] args) throws IOException {

        String username = JOptionPane.showInputDialog("What's your username?");
        Socket socket = new Socket("localhost",12345);
        Client client = new Client(socket,username);
        client.setupWindow(username);
        client.listenForMessage();
        client.sendMessage();


    }

}
