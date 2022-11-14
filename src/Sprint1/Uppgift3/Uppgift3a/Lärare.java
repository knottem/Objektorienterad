package Sprint1.Uppgift3.Uppgift3a;

public class Lärare extends Person {

    protected Kurs[] undervisar;
    private int kursCounter = 0;

    public Lärare(String namn, String personnummer){
        super(namn, personnummer);
    };

    public String getNamn(){
        return namn;
    }

    public void läggTillUndervisadKurs(Kurs kurs){
        undervisar[kursCounter++] = kurs;
    }

}