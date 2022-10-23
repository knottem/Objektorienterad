package Sprint3.Uppgift4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor implements ActionListener{

    JFrame frame = new JFrame("TextEditor");
    JLabel filename = new JLabel("Filnamn:");
    JTextField filenameText = new JTextField();
    JTextArea editorText = new JTextArea(60,70);
    JButton open, save, print, exit;
    JPanel topBar = new JPanel();

    public void editor(){


        open = new JButton("Öppna");
        open.addActionListener(this);
        save = new JButton("Spara");
        save.addActionListener(this);
        print = new JButton("Skriv ut");
        print.addActionListener(this);
        exit = new JButton("Avsluta");
        exit.addActionListener(this);

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
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.editor();
    }
}
