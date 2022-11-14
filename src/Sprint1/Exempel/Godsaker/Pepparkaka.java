package Sprint1.Exempel.Godsaker;

public class Pepparkaka extends Godsak {

    boolean gräddad;
    String form;
    public Pepparkaka(boolean gräddad, String form,
                      int kaloriinnehåll){
        this.gräddad = gräddad;
        this.form = form;
        this.kaloriinehåll = kaloriinnehåll;
    }

    public void printMe(){
        System.out.println("jag är en pepparkaka");
    }
}

