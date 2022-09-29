package Inlämningsuppgift1.Växter;

public class Carnivorousplant extends Plants{


    double protein = 0.2;

    public Carnivorousplant(String name, double heightcm) {
        super(name, heightcm);
    }

    @Override
    public double calculateLiquid() {
       double amount = 0.1 + (protein * (height / 100) );
       return amount;

    }
}
