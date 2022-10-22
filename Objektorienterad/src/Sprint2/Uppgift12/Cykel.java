package Sprint2.Uppgift12;

public class Cykel extends Fordon implements Printable, Hjulburen {

    private int antalVäxlar;
    private int växelJustNu;
    private int hjul = 2;

    public Cykel(int hastighet,int vikt, int antalVäxlar, int växelJustNu) {
        setHastighet(hastighet);
        setVikt(vikt);
        this.antalVäxlar = antalVäxlar;
        this.växelJustNu = växelJustNu;
    }

    public void växla(){

        }

    @Override
    public String toString() {
        return "Cykeln har en hastighet av " + getHastighet() + " och vikt av " + getVikt() + " och har " + antalVäxlar + " växlar, växeln ligger just nu på " + växelJustNu;
    }

    @Override
    public int getAntalHjul() {
        return hjul;
    }
}
