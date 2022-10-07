package Sprint2.Uppgift1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest{


    Square s1 = new Square(3,3);

    @Test
    void testGet(){
        assertEquals(3, s1.getLength());
        assertNotEquals(4, s1.getLength());
        assertEquals(3, s1.getWidth());
        assertNotEquals(4, s1.getWidth());
    }

    @Test
    void getAreaTest() {
        assertEquals(9,s1.getArea());

    }

    @Test
    void getCircumferenceTest() {
        assertEquals(12,s1.getCircumference());
        assertNotEquals(13,s1.getCircumference()); //felaktig testar
    }
}