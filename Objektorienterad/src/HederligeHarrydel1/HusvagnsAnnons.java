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
        return getRubrik() + "\n " + getBeskrivning() + " för bara " + getPris() +
                " kr och är en årsmodell från " + getÅrsmodell() + " med bara " + getAntalmil() +
                " mil och " + getDuschen(dusch) + " med " + bäddar + " antal bäddar\n";
    }


    public String getDuschen(boolean dusch){
        if(dusch){
            duschen = "har en fin dusch";
        }
        else{
            duschen = "utan dusch";
        }
        return duschen;
    }
}
