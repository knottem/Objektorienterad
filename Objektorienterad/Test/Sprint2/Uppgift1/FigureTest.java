package Sprint2.Uppgift1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest implements Figure{

    double x = 25.22222;
    double y = 25.999999;
    double z = 25.499000;

    @Test
    void roundDoubleTest() {
        assertEquals(25.22, roundDouble(x));
        assertEquals(26, roundDouble(y));
        assertEquals(25.50, roundDouble(z));
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getCircumference() {
        return 0;
    }
}