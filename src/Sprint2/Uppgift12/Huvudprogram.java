package Sprint2.Uppgift12;

import java.io.*;
import java.util.ArrayList;

public class Huvudprogram implements Serializable {

    String filepath = "Objektorienterad/src/Sprint2/Uppgift12/f.ser";

    public static void main(String[] args) {
        new Huvudprogram();
    }

    private Huvudprogram(){

        //createFordons(filepath);

        ArrayList<Fordon> fordonLista = readSer(filepath);

        for (Fordon fordon : fordonLista) {
            System.out.println(fordon.toString());
        }




    }





    public void createFordons(String filepath){
        ArrayList<Fordon> fordonList = new ArrayList<>();
        Bil b1 = new Bil(200,1500,6,4);
        Cykel c1 = new Cykel(40,10,23,15);
        Båt b2 = new Båt(30,3000,6000);
        Tåg t1 = new Tåg(180,40000,6);
        fordonList.add(b1);
        fordonList.add(c1);
        fordonList.add(b2);
        fordonList.add(t1);

        createSer(filepath, fordonList);

    }
    public void createSer(String filepath, Object test){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath))){
            out.writeObject(test);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    public ArrayList<Fordon> readSer(String filepath){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath))){
            return (ArrayList<Fordon>)in.readObject();
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /*
    public void printFordon(Fordon fordon){
        fordon.printMe();
    }

    public void printArray(ArrayList fordon){
        for (Object o : fordon) {
            printFordon((Fordon) o);
        }
    }
    public void printList(List fordon){
        for (Object o : fordon) {
            printFordon((Fordon) o);
        }
    }
    public void printPrintable(Fordon printable){
        printable.printMe();
    }
    public void printHjul(Hjulburen hjulburen){
        System.out.println("antal hjul " + hjulburen.getAntalHjul());
    }

     */


}
