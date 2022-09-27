package Uppgift6;

public class Hund extends Däggdjur{

    public Hund(String name) {
        this.name = name;
    }

    @Override
    public void läte() {
        System.out.println("voff voff");
    }
}
