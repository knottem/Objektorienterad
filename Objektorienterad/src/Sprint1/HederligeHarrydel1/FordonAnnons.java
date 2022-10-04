package Sprint1.HederligeHarrydel1;

abstract class FordonAnnons {

    private int pris;
    private String rubrik, beskrivning;
    private int årsmodell;
    private int antalmil;


    public FordonAnnons(int pris, String rubrik, String beskrivning, int årsmodell, int antalmil) {
        this.pris = pris;
        this.rubrik = rubrik;
        this.beskrivning = beskrivning;
        this.årsmodell = årsmodell;
        this.antalmil = antalmil;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getRubrik() {
        return rubrik;
    }

    public void setRubrik(String rubrik) {
        this.rubrik = rubrik;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    public int getÅrsmodell() {
        return årsmodell;
    }

    public void setÅrsmodell(int årsmodell) {
        this.årsmodell = årsmodell;
    }

    public int getAntalmil() {
        return antalmil;
    }

    public void setAntalmil(int antalmil) {
        this.antalmil = antalmil;
    }

    public String getAnnonsText(){
        return null;
    }
}
