package Sprint1.Uppgift1;

public class Person {

    protected String name;
    protected String adress;
    protected int age;

    public Person(String namn, int personnummer) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, String adress, int age){}
    public Person() {}
}
