package Inlämningsuppgift1.Plants;

public abstract class Plants implements Tools {

    protected double height;
    protected String name;
    protected String types;
    protected String liquidType;


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

    public String getLiquidType() {
        return liquidType;
    }

    public String getTypes(){ return types;}

    public double calculateLiquid(){
        return 0;
    }

}
