package HederligeHarrydel1;

abstract class FordonAnnons {

    int pris;
    String rubrik, beskrivning;
    int årsmodell;
    int antalmil;


    public FordonAnnons(int pris, String rubrik, String beskrivning, int årsmodell, int antalmil) {
        this.pris = pris;
        this.rubrik = rubrik;
        this.beskrivning = beskrivning;
        this.årsmodell = årsmodell;
        this.antalmil = antalmil;
    }

    public String getAnnonsText(){
        return null;
    }
}
