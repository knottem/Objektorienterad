package Sprint2.Uppgift7;

import org.junit.jupiter.api.Test;


import static org.testng.Assert.*;

public class InterestTest {

    Interest i1 = new Interest();

    @Test
    public void calculateInterestTest(){
        double sum = 100;
        int year = 1;
        int year2 = 2;
        int year3 = 3;
        int year4 = 4;
        assertEquals(i1.calculateInterest(sum, 1.1,year), 110.00);
        assertEquals(i1.calculateInterest(sum,1.1,year2), 121.00);
        assertEquals(i1.calculateInterest(sum,1.1,year3), 133.10);
        assertEquals(i1.calculateInterest(sum,1.1,year4), 146.41);
    }

}
