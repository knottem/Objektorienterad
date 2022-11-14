package Sprint3.Uppgift6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class F extends JFrame implements ActionListener,FocusListener {


    JButton button1, button2;
    JTextField first = new JTextField();
    JPanel topBar = new JPanel();
    JPanel rest = new JPanel();
    Color color = getBackground();

    void Program(){


        topBar.setLayout(new GridLayout(1,3));
        button1 = new JButton("Clear");
        button1.addActionListener(this);
        button2 = new JButton("Knapp 2");
        button2.addActionListener(this);
        first = new JTextField();
        first.addFocusListener(this);
        topBar.add(button1);
        topBar.add(button2);
        topBar.add(first);
        setLayout(new BorderLayout());
        add(topBar,BorderLayout.NORTH);
        add(rest);



        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            rest.setBackground(color);
        }
        if(e.getSource() == button2){
            rest.setBackground(Color.BLACK);
        }


    }

    public static void main(String[] args) {
        F f = new F();
        f.Program();
    }

    @Override
    public void focusGained(FocusEvent e) {
        first.setBackground(Color.BLUE);
        rest.setBackground(Color.YELLOW);
    }

    @Override
    public void focusLost(FocusEvent e) {
        first.setBackground(Color.WHITE);
        rest.setBackground(color);
    }
}
