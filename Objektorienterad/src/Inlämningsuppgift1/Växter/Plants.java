package Inlämningsuppgift1.Växter;
abstract class Plants {

    double height;
    String name;

    public Plants(String name, double heightcm) {
        this.name = name;
        this.height = heightcm;
    }

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public double calculateLiquid(){
        return 0;
    }
}
