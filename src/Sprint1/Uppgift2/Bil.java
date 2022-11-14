package Sprint1.Uppgift2;

public class Bil extends Fordon implements Printable, Hjulburen{

    private int antalVäxlar;
    private int växelJustNu;
    private int hjul = 4;

    public Bil(int hastighet,int vikt, int antalVäxlar, int växelJustNu){
        setHastighet(hastighet);
        setVikt(vikt);
        this.antalVäxlar = antalVäxlar;
        this.växelJustNu = växelJustNu;

    }

    public void växla(){}

    public void printMe(){
          System.out.println("Bilen har en hastighet av " + getHastighet() + " och vikt av " + getVikt() + " och har " + antalVäxlar + " växlar, växeln ligger just nu på " + växelJustNu);
      }

    @Override
    public int getAntalHjul() {
        return hjul;
    }
}
