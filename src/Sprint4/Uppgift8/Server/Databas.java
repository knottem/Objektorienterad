package Sprint4.Uppgift8.Server;

import java.util.ArrayList;

public class Databas {

    private final ArrayList<Kompis> database;

    Databas(){
        database = new ArrayList<>();
        database.add(new Kompis("Erik", "test@test.com", "101","9900012450"));
        database.add(new Kompis("George", "test1@test.com", "102","8900012450"));
        database.add(new Kompis("Test1", "test2@test.com", "103","7900012450"));
        database.add(new Kompis("test2", "test3@test.com", "104","7500012450"));
        database.add(new Kompis("bobby", "test4@test.com", "105","7400012450"));
        database.add(new Kompis("Leo", "test5@test.com", "106","7300012450"));
        database.add(new Kompis("Tess", "test6@test.com", "107","7200012450"));
    }
    public ArrayList<Kompis> getDatabase() {
        return database;
    }
}
