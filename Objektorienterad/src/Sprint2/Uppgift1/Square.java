package Sprint2.Uppgift1;

public class Square implements Figure{

    protected int length;
    protected int width;

    public Square(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length*width;

    }

    @Override
    public double getCircumference() {
        return length*2 + width*2;
    }
}
