package Sprint2.Uppgift1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest{


    Square s1 = new Square(3,3);

    @Test
    void Test(){
        assertEquals(3, s1.getLength());
        assertNotEquals(4, s1.getLength());
        assertTrue(s1.getWidth() == 3);
        assertFalse(s1.getWidth() == 4);

    }

    @Test
    void getAreaTest() {
        assert(s1.getArea() == 9);

    }

    @Test
    void getCircumferenceTest() {
        assert(s1.getCircumference() == 12);
    }
}