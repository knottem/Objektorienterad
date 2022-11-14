package Sprint2.Uppgift6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChangeTest {

    Change c1 = new Change();

    //Räkna ut växeln
    @Test
    public void getChangeTest(){
        int cost = 500;
        int payed = 700;
        assertEquals(c1.getChange(cost, payed), 200);
        assertNotEquals(c1.getChange(cost, payed), 150);
    }
    //hur mycket av varje valör som ska ges tillbaka
    @Test
    public void getValueAmountTest(){
        int change = 30;
        int value = 10;
        assertEquals(c1.getValueAmount(change, value), 3);
    }

    // När du har räknat ut hur många antal (y) av valör x som ska ges i växel måste du subtrahera
    //dessa från växeln inför nästa iteration Ex: antag att växeln är 654, då ska du ge 6st 100-
    //lappar, sen måste du dra av 600 innan du räknar ut hur många 50-lappar som ska ges
    @Test
    public void removeLargestValueTest(){
        int cost = 450;
        int value = 100;
        int value2 = 50;

        assertEquals(50, c1.removeLargestValue(cost, value, 4));
        assertEquals(0, c1.removeLargestValue(cost, value2, 9));

    }

    @Test
    void valueText() {
        int valueAmount = 3;
        int value = 30;
        assertEquals(c1.valueText(valueAmount, value), "Amount of 30: 3");
    }
}
