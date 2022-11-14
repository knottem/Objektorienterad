package Tools;

import javax.swing.*;
import java.awt.*;

public class Window {


    public void setupWindowChat(String username){

        JFrame frame = new JFrame("Temp");
        JPanel topPanel = new JPanel(), bottomPanel = new JPanel();
        JButton button = new JButton("button");
        JTextField textField = new JTextField();
        JTextArea textArea = new JTextArea(20,40);

        frame.setTitle("Chat: " + username);
        frame.setLayout(new BorderLayout());
        topPanel.add(button);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(textArea);
        JScrollPane scrollBar = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollBar);
        bottomPanel.add(textField);
        bottomPanel.setLayout(new GridLayout(1,1));
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();

    }


    public void setUpWindowTwoQuestions(){

        JFrame frame = new JFrame("Sensor Program;");
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JLabel cityLabel = new JLabel("Stad:");
        JLabel tempLabel = new JLabel("Temperatur:");
        JTextField cityText = new JTextField();
        JTextField tempText = new JTextField();
        JButton button = new JButton("Skicka");

        topPanel.add(cityLabel);
        topPanel.add(cityText);
        topPanel.setLayout(new GridLayout(1,1));

        bottomPanel.add(tempLabel);
        bottomPanel.add(tempText);
        bottomPanel.setLayout(new GridLayout(1,1));

        frame.setLayout(new GridLayout(3,1));
        frame.add(topPanel, 0);
        frame.add(bottomPanel,1);
        frame.add(button,2);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setSize(300,150);
    }

    public static void main(String[] args) {
        Window w = new Window();
        w.setupWindowChat("testPerson");
        Window b = new Window();
        b.setUpWindowTwoQuestions();
    }
}
