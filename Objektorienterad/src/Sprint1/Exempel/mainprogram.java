package Sprint1.Exempel;

import Sprint1.Exempel.Godsaker.Godsak;
import Sprint1.Exempel.Godsaker.Pepparkaka;

public class mainprogram {

    public static void main(String[] args){

        Godsak g = new Godsak(1);

        Pepparkaka p = new Pepparkaka(true, "gubbe", 5);

        Godsak gp = new Pepparkaka(true, "gumma", 7);

        // Pepparkaka pg = new Godsak(7);

        System.out.println(g.kaloriinehåll);
        System.out.println(p.kaloriinehåll);
        System.out.println(gp.kaloriinehåll);

        g.printMe();
        p.printMe();
        gp.printMe();
    }
}
