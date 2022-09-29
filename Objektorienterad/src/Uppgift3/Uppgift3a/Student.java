package Uppgift3.Uppgift3a;

public class Student extends Person {

    protected String namn;
    protected Lärare lärare;
    protected Student[] studenter;
    private int counter = 0;


    public Student(String namn, int personnummer) {
       super(namn, personnummer);
    }

    @Override
    public String toString() {
        return "\nStudent: " + namn;
    }

    public void addToKurs(Kurs kurs){
    }

    public void addToKurs() {
    }
}
