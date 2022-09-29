package Inlämningsuppgift1.Växter;
import Inlämningsuppgift1.Tools;

public class Carnivorousplant extends Plants implements Tools {


    double protein = 0.2;

    public Carnivorousplant(String name, double heightcm) {
        super(name, heightcm);
        types = "Köttätandeväxt";
    }

    @Override
    public double calculateLiquid() {
        double amount = 0.1 + (protein * (height / 100));
        return amount;
    }

}
