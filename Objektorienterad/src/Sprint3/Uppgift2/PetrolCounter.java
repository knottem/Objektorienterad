package Sprint3.Uppgift2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class PetrolCounter implements ActionListener {

    JFrame frame;
    JTextField meterSetting,meterSettingLastYear,gasUsedLastYear;
    JLabel label, label1, label2, label3,label4,label5;
    JPanel questions = new JPanel();
    JPanel answers = new JPanel();
    JPanel results = new JPanel();

    public void petrol(){

    meterSetting = new JTextField(25);
    meterSettingLastYear = new JTextField(25);
    gasUsedLastYear = new JTextField(25);
    meterSetting.addActionListener(this);
    meterSettingLastYear.addActionListener(this);
    gasUsedLastYear.addActionListener(this);

    label = new JLabel("Ange Mätarställning nu:");
    label1 = new JLabel("Ange Mätarställning för ett år sedan:");
    label2 = new JLabel("Ange Antal liter förbrukad bensin:");

    label3 = new JLabel(" ");
    label4 = new JLabel(" ");
    label5 = new JLabel(" ");

    questions.add(label);
    questions.add(label1);
    questions.add(label2);
    questions.setLayout(new GridLayout(3,1));

    answers.add(meterSetting);
    answers.add(meterSettingLastYear);
    answers.add(gasUsedLastYear);
    answers.setLayout(new GridLayout(3,1));


    results.add(label3);
    results.add(label4);
    results.add(label5);
    results.setLayout(new GridLayout(1,3));

    frame = new JFrame("PetrolCalculator");
    frame.setLayout(new BorderLayout());
    frame.add("West", questions);
    frame.add("East", answers);
    frame.add("South", results);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == meterSetting || e.getSource() == meterSettingLastYear || e.getSource() == gasUsedLastYear) {
            Scanner scanMeterSetting = new Scanner(meterSetting.getText());
            Scanner scanMeterSettingLastYear = new Scanner(meterSettingLastYear.getText());
            Scanner scanGasUsedLastYear = new Scanner(gasUsedLastYear.getText());
            if (scanMeterSetting.hasNextDouble() && scanMeterSettingLastYear.hasNextDouble() && scanGasUsedLastYear.hasNextDouble()) {
                double answeredMeterSetting = scanMeterSetting.nextDouble();
                double answeredMeterSettingLastYear = scanMeterSettingLastYear.nextDouble();
                double answeredGasUsedLastYear = scanGasUsedLastYear.nextDouble();

                double distanceDrivenYear = calculateDistanceDrivenDuringLastYear(answeredMeterSetting, answeredMeterSettingLastYear);
                double CPM = calculateAverageGasUsage(distanceDrivenYear, answeredGasUsedLastYear);

                label3.setText(printDistanceDriven(distanceDrivenYear));
                label4.setText(printGas(answeredGasUsedLastYear));
                label5.setText(printCPM(CPM));
            }
        }
    }


    public double calculateDistanceDrivenDuringLastYear(double meterSetting, double meterSettingLastYear){
        return meterSetting - meterSettingLastYear;
    }

    public double calculateAverageGasUsage(double gasUsedLastYear, double distanceDrivenLastYear){
        return gasUsedLastYear / distanceDrivenLastYear;
    }

    public String printDistanceDriven(double distanceDriven){
        return "Antal körda mil: " + distanceDriven;
    }

    public String printGas(double gasUsed){
        return "Antal liter bensin: " + gasUsed;
    }

    public String printCPM(double averageGas){
        return "Förbrukning per mil: " + averageGas;
    }

    public static void main(String[] args) {
        PetrolCounter petrolCounter = new PetrolCounter();
        petrolCounter.petrol();
    }
}
