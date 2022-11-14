package Sprint1.Uppgift7;

import java.util.LinkedList;
import java.util.List;

public class Uppgift7 {

    public static void main(String[] args) {
        Uppgift7 uppgift7a = new Uppgift7();

        Uppgift7 uppgift7b = new Uppgift7("lalala");
    }


    public Uppgift7() {

        Circle c1 = new Circle(5,3,5);
        Triangle t1 = new Triangle(5,5,5,5);
        Rectangle r1 = new Rectangle(5,5,5,5);

        List<Figure> figureList = new LinkedList<>();
        figureList.add(c1);
        figureList.add(t1);
        figureList.add(r1);

        for (Figure figure : figureList) {
            System.out.println("An " + figure.getClass().getSimpleName() + " with an area of " + figure.area());
        }
    }

    public Uppgift7(String uppgift7b) {

        Circle c1 = new Circle(5,3,5);
        Triangle t1 = new Triangle(5,5,5,5);
        Rectangle r1 = new Rectangle(5,5,5,5);

        List figureList = new LinkedList();
        figureList.add(c1);
        figureList.add(t1);
        figureList.add(r1);

        for (Object figure : figureList) {
            System.out.println("An " + figure.getClass().getSimpleName() + " with an area of " + ((Figure)figure).area());
        }
    }
}
