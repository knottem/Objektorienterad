package Inlämningsuppgift1.Plants;

public class Cactus extends Plants implements Tools {

    double liquid = 0.02;

    public Cactus(String name, double heightcm) {
        super(name, heightcm);
        types = "Kaktus";
        liquidType = "Mineral Vatten";
    }

    @Override
    public double calculateLiquid() {
        return liquid;
    }
}
