package Uppgift6;

public class Huvudprogramuppgift6 {

    private Huvudprogramuppgift6(){


        Katt benzin = new Katt();
        Hund hunden = new Hund();

        Djur[] djuren = {benzin, hunden};

        for (int i = 0; i < djuren.length; i++) {
            djuren[i].läte();

        }


    }

    public static void main(String[] args) {
        new Huvudprogramuppgift6();
    }
}
