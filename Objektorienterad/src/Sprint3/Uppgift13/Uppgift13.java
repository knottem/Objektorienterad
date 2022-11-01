package Sprint3.Uppgift13;

import javax.swing.*;
import java.util.ArrayList;

public class Uppgift13 {

    static boolean rerun = true;
    static int testTime = 1;
    static int totalTime = 10000;

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Medicine> medicines = new ArrayList<>();
        String[] mediciner = {"Alvedon","Paracetamol", "Oxycontin"};

        while(rerun) {
            String name = (String) JOptionPane.showInputDialog(null, "Vilken medicin ska du ta?",
                    "Medicin Väljare", JOptionPane.QUESTION_MESSAGE, null, mediciner, mediciner[0]);
            int time = Integer.parseInt(JOptionPane.showInputDialog("Hur ofta ska du ta medicinen i sekunder?"));
            medicines.add(new Medicine(name, time));
            int rerunTest = JOptionPane.showConfirmDialog(null,"Lägg till fler mediciner?");
            if(rerunTest > 0){
                rerun = false;
            }
        }
        Runnable runnable = () ->{
            while (!Thread.interrupted()) {
                try {
                    System.out.println("Tid i sekunder: " + testTime);
                    Thread.sleep(1000);
                    testTime++;
                } catch (InterruptedException e) {
                    System.out.println("Tiden stoppad.");
                    break;
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
        for (Medicine medicine : medicines) {
            medicine.start();
        }


        Thread.sleep(totalTime);
        for (Medicine medicine : medicines) {
            medicine.interrupt();
        }
        t1.interrupt();

    }
}
