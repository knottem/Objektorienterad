package HederligeHarrydel1;

public class BilAnnons extends FordonAnnons{

    String Färg;
    boolean sommardäck;
    boolean vinterdäck;
    String däck;


    public BilAnnons(int pris, String rubrik, String beskrivning, int årsmodell, int antalmil, String färg, boolean sommardäck, boolean vinterdäck) {
        super(pris, rubrik, beskrivning, årsmodell, antalmil);
        Färg = färg;
        this.sommardäck = sommardäck;
        this.vinterdäck = vinterdäck;
    }

    @Override
    public String getAnnonsText() {
        return rubrik + "\n " + beskrivning + " för bara " + pris + " kr och är en årsmodell från " + årsmodell + " med bara " + antalmil + " mil och en fin" + Färg + " färg " + getDäck(sommardäck,vinterdäck) + "\n";
    }



    public String getDäck(boolean sommardäck, boolean vinterdäck){
        if(sommardäck && vinterdäck){
            däck = "med fina sommardäck och vinterdäck";
        }
        else if(sommardäck){
            däck = "med fina sommardäck";
        }
        else if(vinterdäck){
            däck = "med fina vinterdäck";
        }
        else{
            däck = "inga däck ingår";
        }
     return däck;
    }

}
