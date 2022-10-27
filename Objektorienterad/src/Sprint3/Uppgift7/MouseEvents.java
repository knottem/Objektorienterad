package Sprint3.Uppgift7;

import javax.swing.*;
import java.awt.*;

public class MouseEvents{

    JFrame frame = new JFrame("Mouse");
    JPanel panel = new JPanel();
    JButton button = new JButton("Button");
    JButton button2 = new JButton("Test Button");
    mouseAdapter mouseAdapter = new mouseAdapter(button);
    mouseAdapter mouseAdapter2 = new mouseAdapter(button2);

    void Program(){

        button.addMouseListener(mouseAdapter.musTest);
        button2.addMouseListener(mouseAdapter2.musTest2);
        panel.add(button);
        panel.add(button2);
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
