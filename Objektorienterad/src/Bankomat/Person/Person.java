package Bankomat.Person;

abstract class Person {

    final protected String name;
    protected final int ID;

    public Person(String name, int ID){
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
}
