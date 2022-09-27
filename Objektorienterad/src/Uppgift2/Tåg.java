package Uppgift2;

public class Tåg extends Fordon implements Printable, Hjulburen{

    int antalVagnar;
    int hjul = 30;

    public Tåg(int hastighet,int vikt, int antalvagnar) {
        this.hastighet = hastighet;
        this.vikt = vikt;
        this.antalVagnar = antalvagnar;
    }

    public void kopplaVagn(){}

   public void printMe(){
        System.out.println("Tåget har en hastighet av " + hastighet + " och vikt av " + vikt + " och har även " + antalVagnar + " vagnar.");
    }

    @Override
    public int getAntalHjul() {
        return hjul;
    }
}
