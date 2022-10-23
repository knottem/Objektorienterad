package Sprint3.Uppgift4;
import javax.swing.*;
import java.awt.*;

public class TextEditor {

    JFrame frame = new JFrame("TextEditor");
    JLabel filename = new JLabel("Filnamn:");
    JTextField filenameText = new JTextField();
    JTextArea editorText = new JTextArea(60,70);
    JButton open, save, print, exit;
    JPanel topBar = new JPanel();

    public void editor(){

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

        frame.setLayout(new BorderLayout());
        frame.add(topBar,BorderLayout.NORTH);
        frame.add(editorText);

        JScrollPane scroll = new JScrollPane(editorText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
