package Inlämningsuppgift1.Växter;

import Inlämningsuppgift1.Tools;

public class Cactus extends Plants implements Tools {

    double liquid = 0.02;

    public Cactus(String name, double heightcm) {
        super(name, heightcm);
        types = "Cactus";
    }

    @Override
    public double calculateLiquid() {
        return liquid;
    }
}
