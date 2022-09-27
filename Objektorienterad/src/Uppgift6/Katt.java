package Uppgift6;

public class Katt extends Däggdjur{

    public Katt(String name) {
        this.name = name;
    }

    @Override
    public void läte() {
        System.out.println("Mjau Mjau");
    }
}
