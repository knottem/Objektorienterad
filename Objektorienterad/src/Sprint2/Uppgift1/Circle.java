package Sprint2.Uppgift1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle implements Figure{


    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return roundDouble( Math.PI * radius * radius);
    }

    @Override
    public double getCircumference() {
        return roundDouble(2*Math.PI*radius);
    }
}
