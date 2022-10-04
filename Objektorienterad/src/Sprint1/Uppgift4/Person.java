package Sprint1.Uppgift4;

abstract class Person {

    protected String namn;
    protected String personnummer;

    Person(String namn, String personnummer){
        this.namn = namn;
        this.personnummer = personnummer;
    }

    public String getNamn(){
        return namn;
    }

}