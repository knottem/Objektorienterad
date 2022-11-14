package Sprint3.Uppgift4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.*;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class TextEditorB implements ActionListener{

    JFrame frame = new JFrame("TextEditor");
    JLabel filename = new JLabel("Filnamn:");
    JLabel FontText = new JLabel();
    JTextField filenameText = new JTextField();
    JComboBox<String> jComboBox = new JComboBox<>();
    JTextArea editorText = new JTextArea(60,50);
    JButton open, save, print, exit, randomFont, defaultFont;
    JPanel topBar = new JPanel();
    JPanel botBar = new JPanel();
    String[] files = new String[5];

    Font defFont = editorText.getFont();

    public void editor(){

        readFileCache();

        filename.setSize(100,10);
        open = new JButton("Öppna");
        save = new JButton("Spara");
        print = new JButton("Skriv ut");
        exit = new JButton("Avsluta");

        open.addActionListener(this);
        save.addActionListener(this);

        print.addActionListener(e -> {
            try {
                editorText.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        });

        exit.addActionListener(e -> {
                createFileCache();
                System.exit(0);
        });

        jComboBox.setModel(new DefaultComboBoxModel<>(files));
        jComboBox.addActionListener(this);

        topBar.add(filename);
        topBar.add(filenameText);
        topBar.add(jComboBox);
        topBar.add(open);
        topBar.add(save);
        topBar.add(print);
        topBar.add(exit);
        topBar.setLayout(new GridLayout(1,6));

        randomFont = new JButton("Random Font");
        randomFont.addActionListener(this);
        defaultFont= new JButton("Default Font");
        defaultFont.addActionListener(e -> {
            editorText.setFont(defFont);
            FontText.setText(fontString());
        });

        botBar.add(FontText);
        botBar.add(randomFont);
        botBar.add(defaultFont);
        botBar.setLayout(new GridLayout(1,3));


        frame.setLayout(new BorderLayout());
        frame.add(topBar,BorderLayout.NORTH);
        editorText.setFont(new Font("Comic Sans",Font.PLAIN, 30));
        frame.add(editorText);
        frame.add(botBar, BorderLayout.SOUTH);

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
            Scanner scanOpen;
            if(filenameText.getText().isEmpty()) {
                scanOpen = new Scanner(jComboBox.getItemAt(jComboBox.getSelectedIndex()));
            }
            else{
                scanOpen = new Scanner(filenameText.getText());
            }
            if(scanOpen.hasNext()){
                try(BufferedReader br = new BufferedReader(new FileReader("Objektorienterad/src/Sprint3/Uppgift4/" + scanOpen.nextLine() + ".txt"))) {
                    editorText.read(br, null);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(frame,"Filen hittades inte");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        if(e.getSource() == save){
            Scanner scanSave;
            if(filenameText.getText().isEmpty()) {
                scanSave = new Scanner(jComboBox.getItemAt(jComboBox.getSelectedIndex()));
            }
            else{
                scanSave = new Scanner(filenameText.getText());
            }
            if(scanSave.hasNext()){
                try(BufferedWriter bw = new BufferedWriter(new FileWriter("Objektorienterad/src/Sprint3/Uppgift4/" + scanSave.nextLine() + ".txt"))){
                    editorText.write(bw);
                }catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                rearrangeFileCache();
                jComboBox.setModel(new DefaultComboBoxModel<>(files));
            }
        }
        if(e.getSource() == randomFont){
            setRandomFont();
        }
    }

    private void createFileCache(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Objektorienterad/src/Sprint3/Uppgift4/filecache.txt", false))){
            for (String file : files) {
                writer.write(file + " ");
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    private void readFileCache(){
        try(Scanner scan = new Scanner(new File("Objektorienterad/src/Sprint3/Uppgift4/filecache.txt"))){
            String firstLine = scan.nextLine();
            files = firstLine.split(" ");
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(frame,"filecache.txt hittades inte");
        }
    }
    private void setRandomFont(){
        Random random = new Random();
        int i = random.nextInt(3);
        int font = random.nextInt(100);
        if(i==0){
            editorText.setFont(new Font("Arial Black", Font.PLAIN, font));
            FontText.setText(fontString());
        }
        else if(i==1){
            editorText.setFont(new Font("Arial", Font.PLAIN, font));
            FontText.setText(fontString());
        }
        else{
            editorText.setFont(new Font("Times New Roman", Font.PLAIN, font));
            FontText.setText(fontString());
        }

    }

    private void rearrangeFileCache(){
        String value;
            if(filenameText.getText().isEmpty()) {
            value = jComboBox.getItemAt(jComboBox.getSelectedIndex());
                if(!(Objects.equals(value, files[0]))) {
                    for (int i = (jComboBox.getSelectedIndex() - 1); i >= 0; i--) {
                        files[i + 1] = files[i];
                    }
                }
            }
        else{
            value = filenameText.getText();
                if(!(Objects.equals(value, files[0]))) {
                    for (int i = (files.length - 2); i >= 0; i--) {
                        files[i + 1] = files[i];
                    }
                }
            }
        files[0] = value;
    }

    private String fontString(){
        return "Font: " + editorText.getFont().getFontName() + " Size: " + editorText.getFont().getSize();
    }

    public static void main(String[] args) {
        TextEditorB textEditor = new TextEditorB();
        textEditor.editor();
    }
}
