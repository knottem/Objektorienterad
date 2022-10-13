package Sprint2.Uppgift8;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    ReaderA r1 = new ReaderA();


    @Test
    public void checkHighestNumTest(){
        ArrayList<Double> list = new ArrayList<>();
        list.add(20.5);
        list.add(19.9);
        list.add(15.5);
        assertEquals(20.5, r1.checkHighestNum(list));
        assertNotEquals(15.5, r1.checkHighestNum(list));
    }

    @Test
    public void checkLowestNumTest(){
        ArrayList<Double> list = new ArrayList<>();
        list.add(20.5);
        list.add(19.9);
        list.add(15.5);
        assertEquals(15.5, r1.checkLowestNum(list));
        assertNotEquals(20.5, r1.checkLowestNum(list));
    }

    @Test
    public void checkAverageTempTest(){
        ArrayList<Double> list = new ArrayList<>();
        list.add(20.5);
        list.add(19.5);
        list.add(9.5);
        list.add(10.5);
        assertEquals(15.00, r1.checkAverageTemp(list));

    }
}
