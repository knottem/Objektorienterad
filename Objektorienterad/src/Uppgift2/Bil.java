package Uppgift2;

public class Bil extends Fordon implements Printable, Hjulburen{

    int antalVäxlar;
    int växelJustNu;
    int hjul = 4;

    public Bil(int hastighet,int vikt, int antalVäxlar, int växelJustNu){
        this.hastighet = hastighet;
        this.vikt = vikt;
        this.antalVäxlar = antalVäxlar;
        this.växelJustNu = växelJustNu;

    }

    public void växla(){}

    public void printMe(){
          System.out.println("Bilen har en hastighet av " + hastighet + " och vikt av " + vikt + " och har " + antalVäxlar + " växlar, växeln ligger just nu på " + växelJustNu);
      }

    @Override
    public int getAntalHjul() {
        return hjul;
    }
}
