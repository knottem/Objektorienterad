package Sprint1.Uppgift1;

public class Huvudprogram {

    protected Huvudprogram(){

        CarOwner p1 = new CarOwner("Erik", "gatan 1", 30);
        CarOwner p2 = new CarOwner("George", "gatan 2", 20);
        CarOwner p3 = new CarOwner();
        p3.setName("Allan");
        p3.setAdress("gatan 70");
        p3.setAge(50);

        Car c1 = new Car("abc123", "V70", "Volvo");
        c1.newOwner(p1);
        Car c2 = new Car("adb123", "9000", "Saab");
        c2.newOwner(p2);
        Car c3 = new Car("okd560", "M3", "BMW");
        c3.newOwner(p3);

        printCar(c1);
        printCar(c2);
        printCar(c3);
        System.out.println("---------------------------");
        c1.soldCar();
        printCar(c1);
        c1.newOwner(p2);
        System.out.println("---------------------------");
        printCar(c1);
        printCar(c2);
        printCar(c3);
    }
    private void printCar(Car car){
        if(car.owner == null){
            System.out.println(car + " has no owner.");
        }
        else{
            System.out.println(car.owner.getName() + ": " + car);
        }
    }
}
