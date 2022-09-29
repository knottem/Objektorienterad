package Uppgift2;

abstract class Fordon {

    private int hastighet;
    private int vikt;

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

    public void ändraHastighet(int hastighet){
        this.hastighet = hastighet;
    }

    abstract void printMe();

}
