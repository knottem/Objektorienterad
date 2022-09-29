package Inlämningsuppgift1.Växter;

public class Cactus extends Plants{

    double liquid = 0.02;

    public Cactus(String name, double heightcm) {
        super(name, heightcm);
    }

    @Override
    public double calculateLiquid() {
        return liquid;
    }
}
