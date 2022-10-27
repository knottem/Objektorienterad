package Sprint3.Uppgift3;

import Tools.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Change extends Tools implements ActionListener{

    int[] values = new int[10];
    StringBuilder sb = new StringBuilder();
    JFrame frame = new JFrame("Change");
    JTextField payed,cost;
    JLabel label, label1, label2, label3;

    JCheckBox c1000,c500,c200,c100,c50,c20,c10,c5,c2,c1;
    JPanel checkboxes = new JPanel();
    JPanel questions = new JPanel();
    JPanel answers = new JPanel();
    JPanel test = new JPanel();
    JPanel answersValues = new JPanel();
    JPanel finalAnswer = new JPanel();
    ArrayList<String> output = new ArrayList<>();


    public void Program(){

        payed = new JTextField(20);
        cost = new JTextField(20);

        c1000 = new JCheckBox("1000");
        c500 = new JCheckBox("500");
        c200 = new JCheckBox("200");
        c100 = new JCheckBox("100");
        c50 = new JCheckBox("50");
        c20 = new JCheckBox("20");
        c10 = new JCheckBox("10");
        c5 = new JCheckBox("5");
        c2 = new JCheckBox("2");
        c1 = new JCheckBox("1");

        label = new JLabel("Hur mycket betalade du?");
        label1 = new JLabel("Vad kostade varan?");

        questions.add(label);
        questions.add(label1);
        questions.setLayout(new GridLayout(2,1));

        answers.add(payed);
        answers.add(cost);
        answers.setLayout(new GridLayout(2,1));

        label2 = new JLabel("Vilka valutor vill du få tillbaks?");
        answersValues.add(label2);
        answersValues.setLayout(new GridLayout(1,1));

        label3 = new JLabel(" ");
        finalAnswer.add(label3);
        finalAnswer.setLayout(new GridLayout(3,1));

        checkboxes.add(c1000);
        checkboxes.add(c500);
        checkboxes.add(c200);
        checkboxes.add(c100);
        checkboxes.add(c50);
        checkboxes.add(c20);
        checkboxes.add(c10);
        checkboxes.add(c5);
        checkboxes.add(c2);
        checkboxes.add(c1);
        checkboxes.setLayout(new GridLayout(5,2));

        for(Component c : checkboxes.getComponents()){
            if(c instanceof JCheckBox)
                ((JCheckBox)c).addActionListener(this);
        }

        payed.addActionListener(this);
        cost.addActionListener(this);




        test.setLayout(new BorderLayout());
        test.add(answersValues, BorderLayout.NORTH);
        test.add(checkboxes, BorderLayout.CENTER);
        test.add(finalAnswer, BorderLayout.SOUTH);


        frame.setLayout(new BorderLayout());
        frame.add(questions, BorderLayout.WEST);
        frame.add(answers, BorderLayout.EAST);
        frame.add(test, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(c1000.isSelected()){
           values[0] = 1000;
        }
        if(c500.isSelected()){
            values[1] = 500;
        }
        if(c200.isSelected()){
            values[2] = 200;
        }
        if(c100.isSelected()){
            values[3] = 100;
        }
        if(c50.isSelected()){
            values[4] = 50;
        }
        if(c20.isSelected()){
            values[5] = 20;
        }
        if(c10.isSelected()){
            values[6] = 10;
        }
        if(c5.isSelected()){
            values[7] = 5;
        }
        if(c2.isSelected()){
            values[8] = 2;
        }
        if(c1.isSelected()){
            values[9] = 1;
        }
        if(e.getSource() == cost || e.getSource() == payed){
            Scanner scanCost = new Scanner(cost.getText());
            Scanner scanPayed = new Scanner(payed.getText());
            if (scanCost.hasNextInt() && scanPayed.hasNextInt()){
                int answeredCost = scanCost.nextInt();
                int answeredPayed = scanPayed.nextInt();

                int change = getChange(answeredCost, answeredPayed);
                printAll(change);
                Arrays.fill(values, 0);
            }

        }



    }

    public int getChange(int cost, int payed){
        return payed - cost;
    }

    public int getValueAmount(int change, int value){
        return change / value;
    }

    public int removeLargestValue(int change, int value, int getValueAmount){
        return change - getValueAmount * value;
    }

    public String type(int value){
        if(value >= 20){
            return "lappar";
        }
        else{
            return "kronor";
        }
    }

    public void printAll(int change){
        for (int j : values) {
            if (!(j == 0)) {
                int valueAmount = getValueAmount(change, j);
                if (valueAmount >= 1) {
                    output.add(valueText(valueAmount, j));
                }
                change = removeLargestValue(change, j, valueAmount);
            }
        }
        label3.setText(output.toString());
        output.clear();
    }

    public String valueText(int valueAmount, int value){

        //return "Antal " + value + "-" + type(value)+ ": " + valueAmount; //Vanlig String
        sb.setLength(0);
        sb.append("Antal "); //ful StringBuilder
        sb.append(value);
        sb.append("-");
        sb.append(type(value));
        sb.append(": ");
        sb.append(valueAmount);
        return sb.toString();
    }

    public static void main(String[] args) {
        Change c1 = new Change();
        c1.Program();
    }

}

