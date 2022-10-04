package Uppgift8;

import java.util.Random;

public class FigureFabric {

    Random random = new Random();


    public Figure getFigur(String shape) {
        if (shape.equals("circle")) {
            return new Circle(random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1);
        } else if (shape.equals("rectangle")) {
            return new Rectangle(random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1);
        } else if (shape.equals("triangle")) {
            return new Triangle(random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1);
        } else return null;
    }

    public Figure getFigureCircle(){
        return new Circle(random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1);
    }
    public Figure getFigureRectangle(){
        return new Rectangle(random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1);
    }
    public Figure getFigureTriangle(){
        return new Triangle(random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1);
    }
}

