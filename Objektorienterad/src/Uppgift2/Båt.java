package Uppgift2;

public class Båt extends Fordon implements Printable, Hjulburen{

    private int dödvikt;
    private int hjul = 0;

    public Båt(int hastighet,int vikt, int dödvikt) {
        setHastighet(hastighet);
        setVikt(vikt);
        this.dödvikt = dödvikt;
    }

    public void sväng(){}

    public void printMe(){
        System.out.println("Båten har en hastighet av " + getHastighet() + " och vikt av " + getVikt() + " och har även en dödvikt på " + dödvikt);
      }

    @Override
    public int getAntalHjul() {
        return hjul;
    }
}
