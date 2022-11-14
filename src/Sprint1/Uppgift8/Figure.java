package Sprint1.Uppgift8;

abstract public class Figure {

    protected Point StartPoint;

    public Figure(Point p){
        StartPoint=p;
    }

    public abstract double area();

}
