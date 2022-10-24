package Sprint3.Demo;

import javax.swing.*;

public class DemoExtendJFrame extends JFrame {

    DemoExtendJFrame(){
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DemoExtendJFrame();
    }
}
