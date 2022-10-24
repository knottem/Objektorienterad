package Sprint3.Uppgift4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.*;
import java.util.Scanner;

public class TextEditorB implements ActionListener{

    JFrame frame = new JFrame("TextEditor");
    JLabel filename = new JLabel("Filnamn:");
    JTextField filenameText = new JTextField();
    JComboBox<String> jComboBox = new JComboBox<>();
    JTextArea editorText = new JTextArea(60,50);
    JButton open, save, print, exit;
    JPanel topBar = new JPanel();
    String[] files = new String[5];

    public void editor(){

        filename.setSize(100,10);
        open = new JButton("Öppna");
        open.addActionListener(this);
        save = new JButton("Spara");
        save.addActionListener(this);
        print = new JButton("Skriv ut");
        print.addActionListener(this);
        exit = new JButton("Avsluta");
        exit.addActionListener(this);

        files[0] = "test";
        files[1] = "test2";
        files[2] = "test3";
        files[3] = "test4";
        files[4] = "test5";

        jComboBox.setModel(new DefaultComboBoxModel<>(files));
        jComboBox.addActionListener(this);



        topBar.add(filename);
        topBar.add(filenameText);
        topBar.add(jComboBox);
        topBar.add(open);
        topBar.add(save);
        topBar.add(print);
        topBar.add(exit);
        topBar.setLayout(new GridLayout(1,7));


        frame.setLayout(new BorderLayout());
        frame.add(topBar,BorderLayout.NORTH);
        frame.add(editorText);

        JScrollPane scroll = new JScrollPane(editorText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll);

        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == open){
            Scanner scanOpen = new Scanner(jComboBox.getItemAt(jComboBox.getSelectedIndex()));
            if(scanOpen.hasNext()){
                try(BufferedReader br = new BufferedReader(new FileReader("Objektorienterad/src/Sprint3/Uppgift4/" + scanOpen.nextLine() + ".txt"))) {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();

                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    editorText.setText(sb.toString());
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(frame,"Filen hittades inte");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        if(e.getSource() == save){
            Scanner scanSave = new Scanner(filenameText.getText());
            if(scanSave.hasNext()){
                try(BufferedWriter bw = new BufferedWriter(new FileWriter("Objektorienterad/src/Sprint3/Uppgift4/" + scanSave.nextLine() + ".txt"))){
                    String text = editorText.getText();
                    bw.write(text);
                }catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        if(e.getSource() == print){
                try {
                    editorText.print();
                    editorText.print();
                } catch (PrinterException ex) {
                    throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == exit){
            createFileCache();
            System.exit(0);
        }
    }

    void createFileCache(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Objektorienterad/src/Sprint3/Uppgift4/filecache.txt", false))){
            for (String file : files) {
                writer.write(file + " ");
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }


    public static void main(String[] args) {
        TextEditorB textEditor = new TextEditorB();
        textEditor.editor();
    }
}
