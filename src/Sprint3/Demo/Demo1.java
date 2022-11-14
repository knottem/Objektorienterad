package Sprint3.Demo;

import javax.swing.*;
import java.awt.*;

public class Demo1 extends Frame {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dimension = tk.getScreenSize();
    int width = dimension.width-(dimension.width/2);
    int height = dimension.height-(dimension.height/4);

    Demo1(){

        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Demo1();
    }
}
