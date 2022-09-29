package Uppgift2;

public class Tåg extends Fordon implements Printable, Hjulburen{

    private int antalVagnar;
    private int hjul = 30;

    public Tåg(int hastighet,int vikt, int antalvagnar) {
        setHastighet(hastighet);
        setVikt(vikt);
        this.antalVagnar = antalvagnar;
    }

    public void kopplaVagn(){}

   public void printMe(){
        System.out.println("Tåget har en hastighet av " + getHastighet() + " och vikt av " + getVikt() + " och har även " + antalVagnar + " vagnar.");
    }

    @Override
    public int getAntalHjul() {
        return hjul;
    }
}
