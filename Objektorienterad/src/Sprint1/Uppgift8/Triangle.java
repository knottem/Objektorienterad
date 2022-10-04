package Sprint1.Uppgift8;

public class Triangle extends Figure {

    int base;
    int height;

    public Triangle(int startx, int starty, int base, int height) {
        super(new Point(startx, starty));
        this.base = base;
        this.height = height;
    }


    @Override
    public double area() {
        return base*height/2;
    }
}
