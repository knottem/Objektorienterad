package Sprint3.Uppgift1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import javax.swing.*;

public class ImageShow extends JFrame implements ActionListener {

    JButton changeImageButton;
    JLabel imageViewer;
    JPanel panel;
    final ArrayList<String> files = new ArrayList<>();
    int index = 0;
    int counter = 0;

    public void imageShow() throws IOException {

        listFiles(Path.of("Objektorienterad/src/Sprint3/Uppgift1/pics"));

        changeImageButton = new JButton("Change picture");
        changeImageButton.addActionListener(this);

        imageViewer = new JLabel(new ImageIcon(new ImageIcon(files.get(index)).getImage().getScaledInstance(1024,768, Image.SCALE_DEFAULT)));

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(imageViewer);
        panel.add(changeImageButton);
        this.add(panel);

        setSize(1024,900);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if(index<(counter-1)){
            index++;
        }
        else{
            index = 0;
        }
        imageViewer.setIcon(new ImageIcon(new ImageIcon(files.get(index)).getImage().getScaledInstance(1024,768, Image.SCALE_DEFAULT)));
    }

    void listFiles(Path path) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                files.add(entry.toString());
                counter++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ImageShow imageShow = new ImageShow();
        imageShow.imageShow();
    }
}