package Inlämningsuppgift1;

import Inlämningsuppgift1.Växter.Cactus;
import Inlämningsuppgift1.Växter.Carnivorousplant;
import Inlämningsuppgift1.Växter.Palmtree;
import Inlämningsuppgift1.Växter.Plants;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static Inlämningsuppgift1.Tools.joptShowMessage;

public class Programmet {



    public Programmet() {

        String[] plantType = new String[]{"Kaktus", "Köttätandeväxt", "Palm"};

        Cactus Igge = new Cactus("Igge", 20);
        Carnivorousplant Meatloaf = new Carnivorousplant("Meatloaf", 70);
        Palmtree Laura = new Palmtree("Laura", 500);
        Palmtree Putte = new Palmtree("Putte", 100);

        ArrayList<Plants> plantorna = new ArrayList<>();
        plantorna.add(Igge);
        plantorna.add(Meatloaf);
        plantorna.add(Laura);
        plantorna.add(Putte);

        while(true) {
                      int answer = JOptionPane.showConfirmDialog(null, "Hej vill du lägga till en planta eller använda dem som redan finns?\n YES för att lägga till, NO för att gå till nuvarande listan","Title", JOptionPane.YES_NO_OPTION);
                      if(answer == 0){
                          String name = JOptionPane.showInputDialog(null,"Vad heter Plantan?");

                          double height = Double.parseDouble(JOptionPane.showInputDialog(null, "Hur hög är plantan i cm?"));

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
                      break;
                }


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

    }
}
