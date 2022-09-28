package HederligeHarrydel1;

public class HusvagnsAnnons extends FordonAnnons{

    boolean dusch;
    int bäddar;
    String duschen;

    public HusvagnsAnnons(int pris, String rubrik, String beskrivning, int årsmodell, int antalmil, boolean dusch, int bäddar) {
        super(pris, rubrik, beskrivning, årsmodell, antalmil);
        this.dusch = dusch;
        this.bäddar = bäddar;
    }

    @Override
    public String getAnnonsText() {
        if(dusch){
            duschen = "har en fin dusch";
        }
        if(!dusch){
            duschen = "utan dusch";
        }

        return rubrik + "\n " + beskrivning + " för bara " + pris + " kr och är en årsmodell från " + årsmodell + " med bara " + antalmil + " mil och " + duschen + " med " + bäddar + " antal bäddar";
    }
}
