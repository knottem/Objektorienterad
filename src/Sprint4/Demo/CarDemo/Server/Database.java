package Sprint4.Demo.CarDemo.Server;

import java.util.ArrayList;
import java.util.List;


public class Database {

    private final List <Car> allCars = new ArrayList<>();

    public Database(){
        Car c1 = new Car("QWE123", "Kalle", "Saab", "Röd");
        allCars.add(c1);
        Car c2 = new Car("AAA111", "Milla", "Volvo", "blå");
        allCars.add(c2);
        Car c3 = new Car("BBB222", "Pelle", "Audi", "Gul");
        allCars.add(c3);
        Car c4 = new Car("CCC333", "Lotta", "Tesla", "svart");
        allCars.add(c4);
        Car c5 = new Car("DDD444", "Nisse", "Kia", "Silver");
        allCars.add(c5);
    }


    public String getCarData(String s){
        for (Car c :allCars){
            if (c.getRegNr().equalsIgnoreCase(s)){
                return c.getData();
            }
        }
        return null;
    }

}