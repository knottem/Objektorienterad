package Sprint2.Uppgift13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class calcTest {

    calculates calc = new calculates();

    @Test
    public void isOperatorCorrectTest(){
        String sum = "15*3";
        String sum1 = "/15/3";
        String sum2 = "++15+2";
        assertTrue(calc.isOperatorCorrect(sum));
        assertFalse(calc.isOperatorCorrect(sum1));
        assertFalse(calc.isOperatorCorrect(sum2));
    }

    @Test
    public void operatorValTest(){
        String sum = "15*3";
        String sum1 = "20/3";
        String sum2 = "30+2";
        String sum3 = "-30+30";
        assertEquals(calc.operatorVal(sum), "*");
        assertEquals(calc.operatorVal(sum1), "/");
        assertEquals(calc.operatorVal(sum2), "+");
        assertEquals(calc.operatorVal(sum3), "+");
    }

    @Test
    public void num1Test() throws operatorNotSupportedException {
        String sum = "15*3";
        String sum1 = "20/3";
        String sum2 = "30+2";
        assertEquals(calc.num1(sum), 15);
        assertEquals(calc.num1(sum1), 20);
        assertEquals(calc.num1(sum2), 30);
        assertNotEquals(calc.num1(sum2), 50);
    }
    @Test
    public void num2Test() throws operatorNotSupportedException {
        String sum = "15*3";
        String sum1 = "20/3";
        String sum2 = "30+2";
        assertEquals(calc.num2(sum), 3);
        assertEquals(calc.num2(sum1), 3);
        assertEquals(calc.num2(sum2), 2);
        assertNotEquals(calc.num2(sum2), 50);
    }
    @Test
    public void calculateTest() throws operatorNotSupportedException {
        String sum = "30/3";
        String operator = "/";
        double num1 = 30;
        double num2 = 3;
        assertEquals(calc.calculate(sum,operator,num1,num2), 10.0);

        String sum2 = "40+40";
        String operator2 = calc.operatorVal(sum2);
        double num3 = calc.num1(sum2);
        double num4 = calc.num2(sum2);
        assertEquals(calc.calculate(sum2, operator2, num3, num4), 80.0);
        assertNotEquals(calc.calculate(sum2, operator2, num3, num4), 90.0);

    }

    @Test
    public void antalTeckenTest(){
        String sum = "25+++3";
        String sum1 = "25++++++++++5";
        assertEquals(calc.antalTecken(sum, "+"), 3);
        assertEquals(calc.antalTecken(sum1, "+"), 10);
    }
}
