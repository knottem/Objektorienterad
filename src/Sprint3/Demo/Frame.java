package Sprint3.Demo;

import javax.swing.*;

public class Frame {

    JFrame frame = new JFrame();

    void setupFrame(){

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
