package Sprint1.Uppgift9;

public class Uppgift9 {

    public Uppgift9(){


        for(RomanNumeral r : RomanNumeral.values()){
            System.out.println(r + " is " + r.getNumeral() + " -- " + r + " is " + r.getNumber());
        }

    }
    public static void main(String[] args) {
        new Uppgift9();
    }
}
