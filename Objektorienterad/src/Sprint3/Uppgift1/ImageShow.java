package Sprint3.Uppgift1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class ImageShow implements ActionListener {
    JPanel buttons = new JPanel();
    JFrame frame = new JFrame("ImageViewer");
    JLabel imageViewer;
    JButton changeImageButton, randomButton;
    ArrayList<String> files = new ArrayList<>();
    int index = 0;
    int counter = -1;
    Random rand = new Random();

    public void imageShow() throws IOException {

        listFiles(Path.of("Objektorienterad/src/Sprint3/Uppgift1/pics"), files);

        changeImageButton = new JButton("Next picture");
        changeImageButton.addActionListener(this);

        randomButton = new JButton("Random Picture");
        randomButton.addActionListener(this);

        imageViewer = new JLabel(new ImageIcon(new ImageIcon(files.get(index)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT)));

        buttons.add(changeImageButton);
        buttons.add(randomButton);
        buttons.setLayout(new GridLayout(1,2));

        frame.setLayout(new BorderLayout());
        frame.add(imageViewer,BorderLayout.NORTH);
        frame.add(buttons,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == changeImageButton) {
            if (index < counter) {
                index++;
            } else {
                index = 0;
            }
            imageViewer.setIcon(new ImageIcon(new ImageIcon(files.get(index)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT)));
        }
        if(e.getSource() == randomButton){
            index = rand.nextInt(counter+1);
            imageViewer.setIcon(new ImageIcon(new ImageIcon(files.get(index)).getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT)));
        }
    }

    public void listFiles(Path path,ArrayList<String> list) throws IOException {
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