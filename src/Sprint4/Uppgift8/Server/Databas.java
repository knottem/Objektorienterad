package Sprint4.Uppgift8.Server;

import Sprint4.Uppgift8.resources.Kompis;

import java.util.ArrayList;

public class Databas {

    private final ArrayList<Kompis> database;

    Databas(){
        database = new ArrayList<>();
        database.add(new Kompis("Erik", "Testgatan 1","test@test.com", "101","9900012450"));
        database.add(new Kompis("George","Testgatan 2", "test1@test.com", "102","8900012450"));
        database.add(new Kompis("Test1", "Testgatan 3","test2@test.com", "103","7900012450"));
        database.add(new Kompis("test2", "Testgatan 4","test3@test.com", "104","7500012450"));
        database.add(new Kompis("bobby","Testgatan 5", "test4@test.com", "105","7400012450"));
        database.add(new Kompis("Leo", "Testgatan 6","test5@test.com", "106","7300012450"));
        database.add(new Kompis("Tess", "Testgatan 7","test6@test.com", "107","7200012450"));
    }
    public ArrayList<Kompis> getDatabase() {
        return database;
    }
}
