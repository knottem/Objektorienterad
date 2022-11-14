package Sprint2.Uppgift9;

public class Person {

    protected String namn;
    protected String adress;
    protected String postnr;
    protected int age;
    protected int weight;
    protected int length;

    public Person(String namn, String adress, String postnr, int age, int weight, int length) {
        this.namn = namn;
        this.adress = adress;
        this.postnr = postnr;
        this.age = age;
        this.weight = weight;
        this.length = length;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
