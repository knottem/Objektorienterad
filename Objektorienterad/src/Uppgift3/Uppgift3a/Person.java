package Uppgift3.Uppgift3a;

abstract class Person {

    String namn;
    int personnummer;

    public Person(String namn, int personnummer) {
        this.namn = namn;
        this.personnummer = personnummer;
    }

    public String getNamn() {
        return namn;
    }
}
