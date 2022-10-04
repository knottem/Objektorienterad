package Uppgift8;

import java.util.LinkedList;
import java.util.List;

public class Uppgift8 {

    public static void main(String[] args) {
       new Uppgift8();
    }


    public Uppgift8() {

        FigureFabric fabric = new FigureFabric();

        List<Figure> figureList = new LinkedList<>();
        figureList.add(fabric.getFigur("circle"));
        figureList.add(fabric.getFigur("rectangle"));
        figureList.add(fabric.getFigur("triangle"));

        figureList.add(fabric.getFigureCircle());
        figureList.add(fabric.getFigureRectangle());
        figureList.add(fabric.getFigureRectangle());

        for (Figure figure : figureList) {
            System.out.println("An " + figure.getClass().getSimpleName() + " with an area of " + figure.area());
        }
    }

}
