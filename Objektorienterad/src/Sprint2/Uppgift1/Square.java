package Sprint2.Uppgift1;

public class Square implements Figure{

    int length;
    int width;

    @Override
    public double getArea() {
        return length*width;

    }

    @Override
    public double getCircumference() {
        return length*2 + width*2;
    }
}
