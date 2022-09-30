package Inlämningsuppgift1.Program;

import Inlämningsuppgift1.Plants.Cactus;
import Inlämningsuppgift1.Plants.Carnivorousplant;
import Inlämningsuppgift1.Plants.Palmtree;
import Inlämningsuppgift1.Plants.Plants;

import javax.swing.*;
import java.util.ArrayList;

import static Inlämningsuppgift1.Plants.Tools.joptShowMessage;

public class Program extends Window{



    public Program() {

        ArrayList<Plants> plantorna = new ArrayList<>();
        plantorna.add(new Cactus("Igge", 20));
        plantorna.add(new Carnivorousplant("Meatloaf", 70));
        plantorna.add(new Palmtree("Laura", 500));
        plantorna.add(new Palmtree("Putte", 100));

        askWindow(plantorna);

        showWindow(plantorna);

    }
}
