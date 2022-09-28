package Uppgift3a;

public class Student extends Person{


    public Student(String namn, int personnummer) {
        super(namn, personnummer);
    }

    public void addToKurs(Kurs kurs){
        kurs.addKursDeltagare(kurs,namn);
    }

    public void addToKurs() {
    }
}
