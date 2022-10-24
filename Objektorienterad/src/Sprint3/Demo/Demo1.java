package Sprint3.Demo;

import javax.swing.*;

public class Demo1 {

    JFrame frame = new JFrame("Test");

    Demo1(){
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Demo1();
    }
}
