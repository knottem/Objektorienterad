package Sprint4.Uppgift6;

import java.util.ArrayList;

public class Databas {

    private final ArrayList<Kompis> database;

    Databas(){
        database = new ArrayList<>();
        database.add(new Kompis("Erik", "test@test.com", 123456789,9900012450L));
        database.add(new Kompis("George", "test1@test.com", 123456789,8900012450L));
        database.add(new Kompis("Test1", "test2@test.com", 123456789,7900012450L));
        database.add(new Kompis("test2", "test3@test.com", 123456789,7500012450L));
        database.add(new Kompis("bobby", "test4@test.com", 123456789,7400012450L));
        database.add(new Kompis("Leo", "test5@test.com", 123456789,7300012450L));
        database.add(new Kompis("Tess", "test6@test.com", 123456789,7200012450L));
    }
    public ArrayList<Kompis> getDatabase() {
        return database;
    }
}
