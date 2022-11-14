package Sprint2.Uppgift12;

import java.io.Serializable;

abstract class Fordon implements Printable, Serializable {

    private int hastighet;
    private int vikt;

    public Fordon() {
    }

    public int getHastighet() {
        return hastighet;
    }

    public void setHastighet(int hastighet) {
        this.hastighet = hastighet;
    }

    public int getVikt() {
        return vikt;
    }

    public void setVikt(int vikt) {
        this.vikt = vikt;
    }
    public void printMe(){
        System.out.println("Test");
    }
    public void ändraHastighet(int hastighet){
        this.hastighet = hastighet;
    }

}
