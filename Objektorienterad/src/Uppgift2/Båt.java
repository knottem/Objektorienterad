package Uppgift2;

public class Båt extends Fordon implements Printable, Hjulburen{

    int dödvikt;
    int hjul = 0;

    public Båt(int hastighet,int vikt, int dödvikt) {
        this.hastighet = hastighet;
        this.vikt = vikt;
        this.dödvikt = dödvikt;
    }

    public void sväng(){}

    public void printMe(){
        System.out.println("Båten har en hastighet av " + hastighet + " och vikt av " + vikt + "och har även en dödvikt på " + dödvikt);
      }

    @Override
    public int getAntalHjul() {
        return hjul;
    }
}
