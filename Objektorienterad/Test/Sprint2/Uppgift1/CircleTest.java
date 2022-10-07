package Sprint2.Uppgift1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    Circle c1 = new Circle(4);


    @Test
    void getRadius() {
        assertEquals(4, c1.getRadius());
        assertNotEquals(3,c1.getRadius());
    }

    @Test
    void setRadius() {
        c1.setRadius(3);
        assertEquals(3,c1.getRadius());
        c1.setRadius(5);
        assertEquals(5,c1.getRadius());
    }

    @Test
    void getArea() {
       assertEquals(50.27, c1.getArea());
    }

    @Test
    void getCircumference() {
        assertEquals(25.13, c1.getCircumference());
    }
}
