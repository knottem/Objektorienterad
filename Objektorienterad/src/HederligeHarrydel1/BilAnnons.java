package HederligeHarrydel1;

public class BilAnnons extends FordonAnnons{

    String Färg;
    boolean sommardäck;
    boolean vinterdäck;


    public BilAnnons(int pris, String rubrik, String beskrivning, int årsmodell, int antalmil, String färg, boolean sommardäck, boolean vinterdäck) {
        super(pris, rubrik, beskrivning, årsmodell, antalmil);
        Färg = färg;
        this.sommardäck = sommardäck;
        this.vinterdäck = vinterdäck;
    }

    @Override
    public String getAnnonsText() {
        String däck = null;
        if(sommardäck && vinterdäck){
            däck = "med fina sommardäck och vinterdäck";
        }
        if(sommardäck && !vinterdäck){
            däck = "med fina sommardäck";
        }
        if(!sommardäck && vinterdäck){
            däck = "med fina vinterdäck";
        }
        if(!sommardäck && !vinterdäck){
            däck = "inga däck ingår";
        }
        return rubrik + "\n " + beskrivning + " för bara " + pris + " kr och är en årsmodell från " + årsmodell + " med bara " + antalmil + " mil och en fin" + Färg + " färg" + däck;
    }

}
