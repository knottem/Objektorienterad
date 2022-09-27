package Uppgift2;

public class Huvudprogram {

    public static void main(String[] args) {
        new Huvudprogram();
    }

    private Huvudprogram(){

        Bil b1 = new Bil(200,1500,6,4);
        Cykel c1 = new Cykel(40,10,23,15);
        Båt b2 = new Båt(30,3000,6000);
        Tåg t1 = new Tåg(180,40000,6);

        b1.printMe();
        c1.printMe();
        b2.printMe();
        t1.printMe();

        System.out.println("-------------------------------");

        printFordon(b1);
        printFordon(b2);
        printFordon(c1);
        printFordon(t1);

        System.out.println("-------------------------------");

        printPrintable(b1);
        printPrintable(b2);
        printPrintable(c1);
        printPrintable(t1);

        System.out.println("-------------------------------");

        printHjul(b1);
        printHjul(b2);
        printHjul(c1);
        printHjul(t1);

    }
    public void printFordon(Fordon fordon){
        fordon.printMe();
    }
    public void printPrintable(Fordon printable){
        printable.printMe();
    }
    public void printHjul(Hjulburen hjulburen){
        System.out.println("antal hjul " + hjulburen.getAntalHjul());
    }


}
