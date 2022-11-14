package Sprint3.Demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxar extends Frame implements ActionListener{

    JPanel topPanel = new JPanel(new GridLayout(3,1));
    JPanel botPanel = new JPanel();
    JLabel label = new JLabel();
    JCheckBox red = new JCheckBox("Röd");
    JCheckBox yellow = new JCheckBox("Gul");
    JCheckBox blue = new JCheckBox("Blå");
    Color color = botPanel.getBackground();

    void Program(){

        topPanel.add(red);
        topPanel.add(yellow);
        topPanel.add(blue);

        red.addActionListener(this);
        yellow.addActionListener(this);
        blue.addActionListener(this);

        botPanel.add(label);

        frame.setLayout(new GridLayout(2,1));
        frame.add(topPanel);
        frame.add(botPanel);

        setupFrame();
    }


    public static void main(String[] args) {
        CheckBoxar checkboxar = new CheckBoxar();
        checkboxar.Program();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(yellow.isSelected() && !(red.isSelected()) && !(blue.isSelected())){
            label.setText("Gul");
            label.setForeground(Color.BLACK);
            botPanel.setBackground(Color.YELLOW);
        }
        if(red.isSelected() && !(yellow.isSelected()) && !(blue.isSelected())){
            label.setText("Röd");
            label.setForeground(Color.BLACK);
            botPanel.setBackground(Color.RED);
        }
        if(blue.isSelected() && !(yellow.isSelected()) && !(red.isSelected())){
            label.setText("Blå");
            label.setForeground(Color.BLACK);
            botPanel.setBackground(Color.BLUE);
        }
        if(red.isSelected() && blue.isSelected() && !(yellow.isSelected())){
            label.setText("Lila");
            label.setForeground(Color.BLACK);
            botPanel.setBackground(new Color(128, 0, 128));
        }
        if(red.isSelected() && blue.isSelected() && yellow.isSelected()){
            label.setText("Brun");
            label.setForeground(Color.WHITE);
            botPanel.setBackground(new Color(98, 42, 15));
        }
        if(!(red.isSelected()) && !(blue.isSelected()) && !(yellow.isSelected())){
            label.setText("Ingen färg vald");
            label.setForeground(Color.BLACK);
            botPanel.setBackground(color);
        }
    }
}
