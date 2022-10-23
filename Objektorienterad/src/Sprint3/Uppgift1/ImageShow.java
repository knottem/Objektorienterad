package Sprint3.Uppgift1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class ImageShow extends JFrame implements ActionListener {


    JPanel panel;
    JLabel imageViewer;
    ArrayList<String> files = new ArrayList<>();
    int index = 0;
    int counter = -1;
    Random rand = new Random();

    public void imageShow() throws IOException {

        listFiles(Path.of("Objektorienterad/src/Sprint3/Uppgift1/pics"), files);

        JButton changeImageButton = new JButton("Next picture");
        changeImageButton.addActionListener(this);

        JButton randomButton = new JButton(new AbstractAction("Random Picture") {
            @Override
            public void actionPerformed(ActionEvent e) {
                index = rand.nextInt(counter+1);
                imageViewer.setIcon(new ImageIcon(new ImageIcon(files.get(index)).getImage().getScaledInstance(1024,768, Image.SCALE_DEFAULT)));
            }
        });

        imageViewer = new JLabel(new ImageIcon(new ImageIcon(files.get(index)).getImage().getScaledInstance(1024,768, Image.SCALE_DEFAULT)));

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(imageViewer);
        panel.add(changeImageButton);
        panel.add(randomButton);
        this.add(panel);

        setSize(1024,900);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if(index<counter){
            index++;
        }
        else{
            index = 0;
        }
        imageViewer.setIcon(new ImageIcon(new ImageIcon(files.get(index)).getImage().getScaledInstance(1024,768, Image.SCALE_DEFAULT)));
    }

    void listFiles(Path path,ArrayList<String> list) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                list.add(entry.toString());
                counter++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ImageShow imageShow = new ImageShow();
        imageShow.imageShow();
    }
}