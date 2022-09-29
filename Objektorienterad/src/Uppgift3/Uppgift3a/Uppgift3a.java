package Uppgift3.Uppgift3a;

import java.util.ArrayList;
import java.util.Arrays;

public class Uppgift3a {

    public Uppgift3a(){

        Student s1 = new Student("George", 801212);
        Student s2 = new Student("Fred", 701212);
        Lärare l1 = new Lärare("Pär", 670124);
        Lärare l2 = new Lärare("George", 670124);

        ArrayList<Lärare> lärarna = new ArrayList<>();

        lärarna.add(l1);
        lärarna.add(l2);

        lärarna.get(0).getNamn();

        ArrayList<Person> javaKursen = new ArrayList<>();

        javaKursen.add(s1);
        javaKursen.add(s2);
        //addLärare(l1, lärarna, javaKursen);
        //addLärare(l2, lärarna, javaKursen);

        System.out.println(javaKursen);




    }

   /* public void addLärare(Lärare lärare, ArrayList lärarna, ArrayList kursen){
        for (int i = 0; i < lärarna.size(); i++) {
            if(lärarna.get(i).getNamn()) {
                kursen.add(0, lärare);
                break;
            }
        }

    }

    */

    public static void main(String[] args) {
        new Uppgift3a();
    }
}
