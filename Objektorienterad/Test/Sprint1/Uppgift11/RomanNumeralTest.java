package Sprint1.Uppgift11;

import Sprint1.Uppgift9.RomanNumeral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    @Test
    void getNumeral() {
        assert(RomanNumeral.I.getNumeral().equals("one"));
        assert(RomanNumeral.V.getNumeral().equals("five"));
        assert(RomanNumeral.X.getNumeral().equals("ten"));
        assert(RomanNumeral.L.getNumeral().equals("fifty"));
        assert(RomanNumeral.C.getNumeral().equals("a hundred"));
        assert(RomanNumeral.D.getNumeral().equals("five hundred"));
        assert(RomanNumeral.M.getNumeral().equals("a thousand"));
    }

    @Test
    void getNumber() {
        assert(RomanNumeral.I.getNumber() == 1);
        assert(RomanNumeral.V.getNumber() == 5);
        assert(RomanNumeral.X.getNumber() == 10);
        assert(RomanNumeral.L.getNumber() == 50);
        assert(RomanNumeral.C.getNumber() == 100);
        assert(RomanNumeral.D.getNumber() == 500);
        assert(RomanNumeral.M.getNumber() == 1000);
    }
}