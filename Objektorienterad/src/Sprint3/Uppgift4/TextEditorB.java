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
    //JTextField filenameText = new JTextField();
    JComboBox<String> jComboBox = new JComboBox<>();
    JTextArea editorText = new JTextArea(60,50);
    JButton open, save, print, exit;
    JPanel topBar = new JPanel();
    String[] files = new String[5];

    public void editor(){

        readFileCache();

        filename.setSize(100,10);
        open = new JButton("Öppna");
        open.addActionListener(this);
        save = new JButton("Spara");
        save.addActionListener(this);
        print = new JButton("Skriv ut");
        print.addActionListener(this);
        exit = new JButton("Avsluta");
        exit.addActionListener(this);

        jComboBox.setModel(new DefaultComboBoxModel<>(files));
        jComboBox.addActionListener(this);



        topBar.add(filename);
        //topBar.add(filenameText);
        topBar.add(jComboBox);
        topBar.add(open);
        topBar.add(save);
        topBar.add(print);
        topBar.add(exit);
        topBar.setLayout(new GridLayout(1,6));


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
            Scanner scanSave = new Scanner(jComboBox.getItemAt(jComboBox.getSelectedIndex()));
            if(scanSave.hasNext()){
                try(BufferedWriter bw = new BufferedWriter(new FileWriter("Objektorienterad/src/Sprint3/Uppgift4/" + scanSave.nextLine() + ".txt"))){
                    String text = editorText.getText();
                    bw.write(text);
                }catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                rearrangeFileCache();
                jComboBox.setModel(new DefaultComboBoxModel<>(files));
            }
        }

        if(e.getSource() == print){
                try {
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
    private void rearrangeFileCache(){
        String value = jComboBox.getItemAt(jComboBox.getSelectedIndex());
        for (int i = (jComboBox.getSelectedIndex()-1); i>=0; i--){
            files[i+1] = files[i];
        }
        files[0] = value;
    }


    public static void main(String[] args) {
        TextEditorB textEditor = new TextEditorB();
        textEditor.editor();
    }
}
