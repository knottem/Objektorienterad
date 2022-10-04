package Uppgift3.Uppgift3b;

public class Uppgift3b {

    Uppgift3b(){
        Student George = new Student("George", "8003021234");
        Student Pelle = new Student("Pelle", "1212121212");
        Student Marcie = new Student("Marcie", "8512159876");

        Lärare Sigrun = new Lärare("Sigrun", "");

        Kurs Javakursen = new Kurs("Objektorientering och Java");

        Javakursen.läggTillStudent(George);
        Javakursen.läggTillStudent(Pelle);
        Javakursen.läggTillStudent(Marcie);
        Javakursen.läggTillLärare(Sigrun);

        George.läggTillKurs(Javakursen);
        Pelle.läggTillKurs(Javakursen);
        Marcie.läggTillKurs(Javakursen);

        printKurs(Javakursen);
    }

    public void printKurs(Kurs kurs){

        System.out.println("Kurs: " + kurs.getNamn());
        System.out.println("Lärare: " + kurs.getLärare().getNamn());

        for (Student s : kurs.getStudenter()){
            if (s != null) {
                System.out.println("Student: " + s.getNamn());
            }
        }
    }

    public static void main(String[] args) {
        Uppgift3b övn3 = new Uppgift3b();
    }

}