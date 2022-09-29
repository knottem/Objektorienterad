package Uppgift3.Uppgift3a;
public class Lärare extends Person {
    @Override
    public String toString() {
        return "\nLärare \n" +
                "Namn: " + namn + "\n";
    }

    public Lärare(String namn, int personnummer) {
        super(namn, personnummer);
    }
}
