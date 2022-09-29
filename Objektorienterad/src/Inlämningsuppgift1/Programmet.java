package Inlämningsuppgift1;

import Inlämningsuppgift1.Växter.Cactus;
import Inlämningsuppgift1.Växter.Carnivorousplant;
import Inlämningsuppgift1.Växter.Palmtree;

import java.util.ArrayList;
import java.util.List;

public class Programmet {

    public Programmet(){

        Cactus Igge = new Cactus("Igge",20);
        Carnivorousplant Meatloaf = new Carnivorousplant("Meatlaof", 70);
        Palmtree Laura = new Palmtree("Laura",500);
        Palmtree Putte = new Palmtree("Putte",100);

        System.out.println(Igge.getName() + ": " + Igge.calculateLiquid());
        System.out.println(Meatloaf.getName() + ": " + Meatloaf.calculateLiquid());
        System.out.println(Laura.getName() + ": " + Laura.calculateLiquid());
        System.out.println(Putte.getName() + ": " + Putte.calculateLiquid());

    }
}
