package Sprint1.Uppgift4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Uppgift4 {

    Uppgift4(){
        Student Anna = new Student("Anna", "8003021234");
        Student Tolvan = new Student("Tolvan", "1212121212");
        Student Pelle = new Student("Pelle", "8512159876");
        Student Mimmi = new Student("Mimmi", "8905031234");

        Lärare Sigrun = new Lärare("Sigrun", "");
        Lärare David = new Lärare("David", "19990505");

        Kurs ObjectJava = new Kurs("Objektorientering och Java");
        ObjectJava.läggTillLärare(Sigrun);

        Kurstillfälle kurstillfälle = new Kurstillfälle(ObjectJava, new Date());

        Kurs Idrott = new Kurs("Databasteknik");
        Idrott.läggTillLärare(David);

        Deltagande d1 = new Deltagande(ObjectJava, Anna);
        Deltagande d2 = new Deltagande(ObjectJava, Tolvan);
        Deltagande d3 = new Deltagande(ObjectJava, Pelle);
        Deltagande d4 = new Deltagande(Idrott, Pelle);
        Deltagande d5 = new Deltagande(Idrott, Mimmi);

        List<Deltagande> allaDeltagare = new ArrayList();
        allaDeltagare.add(d1);
        allaDeltagare.add(d2);
        allaDeltagare.add(d3);
        allaDeltagare.add(d4);
        allaDeltagare.add(d5);

        kurstillfälle.läggTillStudent(Anna);
        kurstillfälle.läggTillStudent(Tolvan);
        kurstillfälle.läggTillStudent(Pelle);
        kurstillfälle.läggTillLärare(Sigrun);

        kurstillfälle.printKurstillfälle();
        System.out.println("");

        printStudent(Pelle, allaDeltagare);
    }

    public void printStudent(Student student, List<Deltagande> allaDeltagare){

        System.out.println("Student: " + student.getNamn());

        for (Deltagande d : allaDeltagare){
            if (d.getStudent() == student)
                System.out.println("Kurs: " + d.getKurs().getNamn());
        }
    }

    public static void main(String[] args) {
        Uppgift4 övn3 = new Uppgift4();
    }

}