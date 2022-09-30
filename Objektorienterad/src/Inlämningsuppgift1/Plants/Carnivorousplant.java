package Inlämningsuppgift1.Plants;

public class Carnivorousplant extends Plants implements Tools {


    double protein = 0.2;

    public Carnivorousplant(String name, double heightcm) {
        super(name, heightcm);
        types = "Köttätandeväxt";
        liquidType = "Proteindryck";
    }

    @Override
    public double calculateLiquid() {
        double amount = 0.1 + (protein * (height / 100));
        return amount;
    }

}
