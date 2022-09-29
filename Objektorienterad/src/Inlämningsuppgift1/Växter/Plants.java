package Inlämningsuppgift1.Växter;

import Inlämningsuppgift1.Tools;

public class Plants implements Tools {

    double height;
    String name;
    String types;


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

    public String getTypes(){ return types;}

    public double calculateLiquid(){
        return 0;
    }

}
