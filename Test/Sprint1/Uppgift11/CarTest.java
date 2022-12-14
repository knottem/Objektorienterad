package Sprint1.Uppgift11;

import Sprint1.HederligeHarrydel1.Uppgift1.Car;
import Sprint1.HederligeHarrydel1.Uppgift1.CarOwner;
import org.junit.jupiter.api.Test;

public class CarTest{


    Car c1 = new Car("asd456", "Panda", "Fiat");

    CarOwner c3 = new CarOwner("Kalle", "hemma", 45);
    CarOwner c4 = new CarOwner("Sally", "hemma", 24);



    @Test
    void getOwnerTest() {
        assert(c1.getOwner() == null);
        c1.newOwner(c3);
        assert(c3.getName().equals("Kalle"));//vi ser at ägaren har ändrats, precis som vi vill!
        assert(c1.getOwner().getName().equals("Kalle"));
        assert(c3.getName() != null);
        c1.newOwner(c4);
        assert(c1.getOwner().getName().equals("Sally"));

    }
}
