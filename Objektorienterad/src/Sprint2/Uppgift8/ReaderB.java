package Sprint2.Uppgift8;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderB {

    double min = 999;
    double max = 0;


    public void Program() throws IOException {

        ArrayList<Double> list = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File("Objektorienterad/src/Sprint2/Uppgift8/temp.txt"))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextDouble());
            }
        }catch (Exception e){
            System.out.println("fel");
        }
        System.out.println(checkHighestNum(list));
        System.out.println(checkLowestNum(list));
        System.out.println(checkAverageTemp(list));

    }

    public double checkLowestNum(ArrayList<Double> list) {
        for (Double aDouble : list) {
            if (aDouble < min) {
                min = aDouble;
            }
        }
        return min;
    }
    public double checkHighestNum(ArrayList<Double> list) {
        for (Double aDouble : list) {
            if (aDouble > max) {
                max = aDouble;
            }
        }
        return max;
    }

    public double checkAverageTemp(ArrayList<Double> list){
        double value = 0;
        for (Double aDouble : list) {
            value = value + aDouble;
        }
        return value / list.size();
    }

    public static void main(String[] args) throws IOException {
        ReaderB r1 = new ReaderB();
        r1.Program();
    }


}
