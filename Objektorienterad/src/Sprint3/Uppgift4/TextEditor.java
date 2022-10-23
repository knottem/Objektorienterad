package Sprint3.Uppgift4;
import javax.swing.*;
import java.awt.*;

public class TextEditor {



    JFrame frame = new JFrame("TextEditor");
    JLabel filename;
    JTextField filenameText;
    JTextArea editorText;
    JButton open, save, print, exit;
    JPanel topBar = new JPanel();
    JPanel textPanel = new JPanel();

    public void editor(){

        filename = new JLabel("Filnamn:");
        filenameText = new JTextField();
        open = new JButton("Öppna");
        save = new JButton("Spara");
        print = new JButton("Skriv ut");
        exit = new JButton("Avsluta");

        topBar.add(filename);
        topBar.add(filenameText);
        topBar.add(open);
        topBar.add(save);
        topBar.add(print);
        topBar.add(exit);
        topBar.setLayout(new GridLayout(1,6));


        editorText = new JTextArea(60,70);
        textPanel.add(editorText);


        frame.setLayout(new BorderLayout());
        frame.add(topBar,BorderLayout.NORTH);
        frame.add(textPanel);

        JScrollPane scroll = new JScrollPane(textPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scroll);

        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.editor();
    }
}
