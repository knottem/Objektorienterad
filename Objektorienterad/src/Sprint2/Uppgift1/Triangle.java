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
        return Math.sqrt(((base/2)*(base/2)) + (height*height));
    }

    @Override
    public double getCircumference() {
        double answer = lengthOfOneSide()*2 + base;
        BigDecimal bigDecimal = BigDecimal.valueOf(answer).setScale(1, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();

    }
}
