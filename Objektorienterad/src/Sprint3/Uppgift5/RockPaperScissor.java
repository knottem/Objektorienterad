package Sprint3.Uppgift5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissor implements ActionListener {

    JFrame frame = new JFrame("Rock Paper Scissor Game");
    JButton playerRock,playerPaper,playerScissor, cpuRock,cpuPaper, cpuScissor;
    JPanel middleBar, bottomBar, middleBarLeft,middleBarCenter,middleBarRight;
    JLabel playerLabel = new JLabel("Player");
    JLabel cpuLabel = new JLabel("CPU");
    Player player = new Player("");
    Cpu cpu = new Cpu();
    JLabel playerScore = new JLabel("Player Score: 0");
    JLabel cpuScore = new JLabel();

    JLabel roundResult = new JLabel("CPU vann denna runda.");
    String playerMove, cpuMove;



    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dimension = tk.getScreenSize();
    int width = (int) (dimension.width-(dimension.width/1.3));
    int height = dimension.height-(dimension.height/2);



    void Program(){

        playerRock = new JButton("Sten");
        playerRock.addActionListener(this);
        playerScissor = new JButton("Sax");
        playerScissor.addActionListener(this);
        playerPaper = new JButton("Påse");
        playerPaper.addActionListener(this);


        cpuRock = new JButton("Sten");
        cpuScissor = new JButton("Sax");
        cpuPaper = new JButton("Påse");

        middleBarLeft = new JPanel();
        middleBarLeft.setLayout(new GridLayout(4,1));
        middleBarLeft.add(playerLabel);
        middleBarLeft.add(playerRock);
        middleBarLeft.add(playerScissor);
        middleBarLeft.add(playerPaper);



        middleBarRight = new JPanel();
        middleBarRight.setLayout(new GridLayout(4,1));
        middleBarRight.add(cpuLabel);
        middleBarRight.add(cpuRock);
        middleBarRight.add(cpuScissor);
        middleBarRight.add(cpuPaper);


        middleBarCenter = new JPanel();
        middleBarCenter.setLayout(new GridLayout(1,2));
        middleBarCenter.add(playerScore);
        middleBarCenter.add(cpuScore);


        middleBar = new JPanel();
        middleBar.setLayout(new BorderLayout());
        middleBar.add(middleBarLeft, BorderLayout.WEST);
        middleBar.add(middleBarCenter,BorderLayout.CENTER);
        middleBar.add(middleBarRight, BorderLayout.EAST);

        bottomBar = new JPanel();
        bottomBar.add(roundResult);

        frame.setLayout(new BorderLayout());
        frame.add(middleBar,BorderLayout.CENTER);
        frame.add(bottomBar, BorderLayout.SOUTH);

        frame.setSize(width,height);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        player.setName(JOptionPane.showInputDialog("Vad är ditt namn?"));
        if(player.getName() != null){
            playerScore.setText(player.getName() +" Score: 0");
        }

        cpuScore.setText(Cpu.getName() +" Score: 0");
    }

    private String cpuMove(){
        Random random = new Random();
        String cpu = null;
        int rand = random.nextInt(3)+1;
        if(rand == 1){
            cpu = "Sten";
            cpuRock.setBackground(Color.GRAY);
        }
        if(rand == 2){
            cpu = "Sax";
            cpuScissor.setBackground(Color.GRAY);
        }
        if(rand == 3){
            cpu = "Påse";
            cpuPaper.setBackground(Color.GRAY);
        }
        return cpu;
    }
    private void returnAllButtons(){
        Color color = new JButton().getBackground();
        playerRock.setBackground(color);
        playerScissor.setBackground(color);
        playerPaper.setBackground(color);
        cpuRock.setBackground(color);
        cpuScissor.setBackground(color);
        cpuPaper.setBackground(color);
    }

    private void choiceRound(){
        if(playerMove.equals(cpuMove)){
            roundResult.setText("Ni valde samma, det blev lika");
        }
        if(playerMove.equals("Sten") && cpuMove.equals("Sax")){
            roundResult.setText("Spelaren vann denna runda med Sten vs Sax");
            scoreUpdate(true);
        }
        if(playerMove.equals("Sten") && cpuMove.equals("Påse")){
            roundResult.setText("CPU vann denna runda med Sten vs Påse");
            scoreUpdate(false);
        }
        if(playerMove.equals("Sax") && cpuMove.equals("Sten")){
            roundResult.setText("CPU vann denna runda med Sax vs Sten");
            scoreUpdate(false);
        }
        if(playerMove.equals("Sax") && cpuMove.equals("Påse")){
            roundResult.setText("Spelaren vann denna runda med Sax vs Påse");
            scoreUpdate(true);
        }
        if(playerMove.equals("Påse") && cpuMove.equals("Sten")){
            roundResult.setText("Spelaren vann denna runda med Påse vs Sten");
            scoreUpdate(true);
        }
        if(playerMove.equals("Påse") && cpuMove.equals("Sax")){
            roundResult.setText("CPU vann denna runda med Påse vs Sax");
            scoreUpdate(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == playerRock || e.getSource() == playerScissor || e.getSource() == playerPaper) {
            returnAllButtons();

            if (e.getSource() == playerRock) {
                playerMove = "Sten";
                playerRock.setBackground(Color.GRAY);
            }
            if (e.getSource() == playerScissor) {
                playerMove = "Sax";
                playerScissor.setBackground(Color.GRAY);
            }
            if (e.getSource() == playerPaper) {
                playerMove = "Påse";
                playerPaper.setBackground(Color.GRAY);
            }

            cpuMove = cpuMove();
            choiceRound();

        }
    }

    private void scoreUpdate(boolean playerTrue){
        if(playerTrue){
            player.setScore();
            playerScore.setText(player.getName() +" Score " + player.getScore());
        }
        else{
            cpu.setScore();
            cpuScore.setText(Cpu.getName() + " Score: " + cpu.getScore());
        }
    }

    public static void main(String[] args) {
        RockPaperScissor rps = new RockPaperScissor();
        rps.Program();
    }


}
