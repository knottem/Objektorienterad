package Sprint3.Uppgift7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouseAdapter {

    JButton button;
    Color color;

    public mouseAdapter(JButton button) {
        this.button = button;
        color = button.getBackground();
    }


    MouseAdapter musTest = new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e){
            button.setBackground(Color.BLACK);
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            button.setBackground(Color.BLACK);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(color);
        }
    };
    MouseAdapter musTest2 = new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e){
            button.setBackground(Color.RED);
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            button.setBackground(Color.BLACK);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(color);
        }
    };


}
