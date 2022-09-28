package HederligeHarrydel1;

public class MotorCykelAnnons extends FordonAnnons{

    double motorvolym;
    String drivtyp;

    public MotorCykelAnnons(int pris, String rubrik, String beskrivning, int årsmodell, int antalmil, double motorvolym, String drivtyp) {
        super(pris, rubrik, beskrivning, årsmodell, antalmil);
        this.motorvolym = motorvolym;
        this.drivtyp = drivtyp;
    }

    @Override
    public String getAnnonsText() {
        return rubrik + "\n " + beskrivning + " för bara " + pris + " kr och är en årsmodell från " + årsmodell + " med bara " + antalmil + " mil och en " + motorvolym + " motorvolym och drivtypen är " + drivtyp + "\n";
    }
}
