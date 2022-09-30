package Inlämningsuppgift1.Plants;

public class Palmtree extends Plants {

    double liquid = 0.5;

    public Palmtree(String name, double heightcm) {
        super(name, heightcm);
        types = "Palm";
        liquidType = "Vatten";
    }

    public double calculateLiquid(){
        double amount = liquid*(height/100);
        return amount;
    }
}
