package Sprint2.Uppgift1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest{

    int width = 3;
    int length = 3;


    @Test
    void getAreaTest() {
        assert(width*length == 9);

    }

    @Test
    void getCircumferenceTest() {
        assert(width*2 + length*2 == 12);
    }
}