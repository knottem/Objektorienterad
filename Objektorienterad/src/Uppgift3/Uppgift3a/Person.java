package Uppgift3.Uppgift3a;

abstract class Person {

    String namn;
    int personnummer;

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(int personnummer) {
        this.personnummer = personnummer;
    }

    public Person(String namn, int personnummer) {
        this.namn = namn;
        this.personnummer = personnummer;
    }

    public String getNamn() {
        return namn;
    }
}
