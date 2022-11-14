package Sprint3.Uppgift7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button implements MouseListener {

    private final JButton button;
    private final Color color;
    private final int id;

    public JButton getButton() {
        return button;
    }

    public Button(JButton button, int id) {
        this.button = button;
        this.color = button.getBackground();
        this.id = id;
        this.button.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(id == 1) {
            button.setBackground(Color.BLACK);
        }
        else if(id == 2){
            button.setBackground(Color.RED);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(id == 1) {
            button.setBackground(Color.BLACK);
        }
        else if(id == 2){
            button.setBackground(Color.RED);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(color);
    }
}
