package Sprint2.Uppgift1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle implements Figure{

    private double base;
    private double height;


    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return base*height/2;
    }

    private double lengthOfOneSide(){
        return Math.sqrt(((base/2)*(base/2)) + (height*height)); //roten av pythagoras sats get längden på sidorna i en likbent triangel
    }

    @Override
    public double getCircumference() {
        return roundDouble(lengthOfOneSide()*2 + base);

    }
}
