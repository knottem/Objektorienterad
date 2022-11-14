package Sprint4.Uppgift14;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Objects;

public class Properties {

    JFrame frame;
    JLabel label;
    JButton button;
    int fStyle;
    java.util.Properties p = new java.util.Properties();

    public Properties(){

        setupWindow();
        applySettings();

    }

    public void setupWindow(){
        frame = new JFrame("TestTitle");
        label = new JLabel("message", JLabel.CENTER);
        button = new JButton();
        frame.add(button);
        frame.add(label);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void applySettings(){
        try{
            p.loadFromXML(new FileInputStream("Objektorienterad/src/Sprint4/Uppgift14/properties.xml"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(Objects.equals(p.getProperty("fontStyle"), "BOLD")){
            fStyle = Font.BOLD;
        }
        else if(Objects.equals(p.getProperty("fontStyle"), "ITALIC")){
            fStyle = Font.ITALIC;
        }
        else{
            fStyle = Font.PLAIN;
        }
        button.setSize(Integer.parseInt(p.getProperty("buttonSize", "100")), Integer.parseInt(p.getProperty("buttonSize", "100")));
        frame.setTitle(p.getProperty("Title", "Hello"));
        label.setText(p.getProperty("message", "Hello"));
        label.setFont(new Font(p.getProperty("fontName", "Serif"), fStyle, Integer.parseInt(p.getProperty("fontSize", "24"))));
    }


    public static void main(String[] args) {
        Properties p = new Properties();
    }
}
