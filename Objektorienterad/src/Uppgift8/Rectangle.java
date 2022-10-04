package Uppgift8;

public class Rectangle extends Figure {

    int width;
    int height;

    public Rectangle(int startx, int starty, int width, int height){
        super(new Point(startx,starty));
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width*height;
    }
}
