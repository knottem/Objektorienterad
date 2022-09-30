package Inlämningsuppgift1.Program;

import Inlämningsuppgift1.Plants.Cactus;
import Inlämningsuppgift1.Plants.Carnivorousplant;
import Inlämningsuppgift1.Plants.Palmtree;
import Inlämningsuppgift1.Plants.Plants;


import javax.swing.*;
import java.util.ArrayList;

import static Inlämningsuppgift1.Plants.Tools.joptShowMessage;

public class Window {

    public void askWindow(ArrayList<Plants> plantorna){

        String[] plantType = new String[]{"Kaktus", "Köttätandeväxt", "Palm"};

        while(true) {
            int answer = JOptionPane.showConfirmDialog(null, "Hej vill du lägga till en planta eller använda dem som redan finns?\n YES för att lägga till, NO för att gå till nuvarande listan","Title", JOptionPane.YES_NO_OPTION);
                if(answer == 0){
                    String name = JOptionPane.showInputDialog(null,"Vad heter Plantan?");
                    double height = Double.parseDouble(JOptionPane.showInputDialog(null, "Hur hög är plantan i cm?"));
                        if(height <= 0){
                            JOptionPane.showMessageDialog(null, "Plantan kan inte vara 0 cm eller negativt value");
                            continue;
                        }
                    Object choice = JOptionPane.showInputDialog(null, "Välj Planttypen", "Plantväljare", JOptionPane.QUESTION_MESSAGE, null, plantType, plantType[0]);
                        if(choice == "Kaktus"){
                            plantorna.add(new Cactus(name, height));
                        }
                        else if(choice == "Köttätandeväxt"){
                            plantorna.add(new Carnivorousplant(name, height));
                        }
                        else if(choice == "Palm"){
                            plantorna.add(new Palmtree(name, height));
                        }
                }
                else{
                    break;
                }
        }
    }

    public void showWindow(ArrayList<Plants> plantorna){

        while (true) {

            String[] plants = new String[plantorna.size()];

            for (int i = 0; i < plantorna.size(); i++) {
                String test = plantorna.get(i).getName() + " - " + plantorna.get(i).getTypes();
                plants[i] = test;
            }

            Object choice = JOptionPane.showInputDialog(null, "Välj Plantan", "Plantväljare", JOptionPane.QUESTION_MESSAGE, null, plants, plants[0]);

            for (int i = 0; i < plantorna.size(); i++) {
                if (choice == plants[i]) {
                    joptShowMessage(plantorna.get(i));
                }
            }

            int answer = JOptionPane.showConfirmDialog(null, "Kör Programmet igen?","Title", JOptionPane.YES_NO_OPTION);
            if(answer == 1){
                break;
            }
        }


    }


}
