package Sprint2.Uppgift1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle t1 = new Triangle(4,4);

    @Test
    void getArea() {
        assertEquals(8, t1.getArea());
        assertNotEquals(16, t1.getArea());
    }

    @Test
    void getCircumference() {
        assertEquals(12.9,t1.getCircumference());
    }

    @Test
    void testGet(){
        assertEquals(4, t1.getBase());
        assertNotEquals(3, t1.getBase());
        assertEquals(4,t1.getHeight());

        t1.setBase(2);
        t1.setHeight(2);

        assertEquals(2,t1.getBase());
        assertEquals(2,t1.getHeight());

    }

}