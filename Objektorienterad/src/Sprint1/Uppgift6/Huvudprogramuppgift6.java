package Sprint1.Uppgift6;

public class Huvudprogramuppgift6 {

    private Huvudprogramuppgift6(){


        Katt benzin = new Katt("Benzin");
        Hund hunden = new Hund("Bamse");
        Duva duvan = new Duva("Fågelfan");
        Aborre aborren = new Aborre("fisken");


        Djur[] djuren = {benzin, hunden, duvan, aborren};

        for (int i = 0; i < djuren.length; i++) {
            System.out.println(djuren[i].name + ":");
            djuren[i].läte();
        }


    }

    public static void main(String[] args) {
        new Huvudprogramuppgift6();
    }
}
