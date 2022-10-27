package Sprint3.Uppgift7;

import javax.swing.*;
import java.awt.*;

public class MouseEvents{

    JFrame frame = new JFrame("Mouse");
    JPanel panel = new JPanel();
    Button b = new Button(new JButton("Button"),1);
    Button b2 = new Button(new JButton("Button2"),2);

    void Program(){

        panel.add(b.getButton());
        panel.add(b2.getButton());

        panel.setLayout(new GridLayout(1,2));

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }


    public static void main(String[] args) {
        MouseEvents m = new MouseEvents();
        m.Program();
    }
}
