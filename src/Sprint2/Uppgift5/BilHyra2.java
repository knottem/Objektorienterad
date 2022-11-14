package Sprint2.Uppgift5;

import static javax.swing.JOptionPane.*;
import java.util.*;

public class BilHyra2 {

  public static void main (String[] arg) {

      String indata = showInputDialog("Ange antal dagar, pris per dag samt bilmodell");

      String fel = "";
      int antalDagar = 0;
      double dagsPris = 0;
      String bil = null;
      boolean test = false;

      // Fixa try catch med all denna data, kör while loop tills det blir rätt

      while (!test) {

          Scanner scan = new Scanner(indata);

          try {
              antalDagar = scan.nextInt();
              dagsPris = scan.nextDouble();
              bil = scan.next();
              test = true;

          } catch (InputMismatchException e) {
              fel = "Felakta nummer!";
          }

          if(!test){
              indata = showInputDialog(fel + " Ange antal dagar, pris per dag samt bilmodell");
          }
      }

    double totPris = dagsPris * antalDagar;
    String s = String.format("Totalt pris för %s: %.2f", bil, totPris);
    showMessageDialog(null, s);

  }

}

