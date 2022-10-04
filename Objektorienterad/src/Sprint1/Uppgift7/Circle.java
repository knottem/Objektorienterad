package Sprint1.Uppgift7;

public class Circle extends Figure{

    int radius;

    public Circle(int startx, int starty, int radius) {
        super(new Point(startx, starty));
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
