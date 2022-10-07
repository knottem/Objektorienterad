package Sprint2.Uppgift1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest{


    Square s1 = new Square(3,3);

    @Test
    void Test(){
        assertEquals(3, s1.getLength());
        assertNotEquals(4, s1.getLength());
        assertEquals(3, s1.getWidth());
        assertNotEquals(4, s1.getWidth());

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