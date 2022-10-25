package Sprint3.Uppgift7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEvents implements MouseListener{


    JFrame frame = new JFrame("Mouse");
    JPanel panel = new JPanel();
    JButton button = new JButton("Button");
    JButton button2 = new JButton("Test Button");
    Color color = button.getBackground();

    void Program(){

        button.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(color);
    }
}
