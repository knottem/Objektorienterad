package Sprint2.Uppgift8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderA {

    double min = 999;
    double max = 0;

    public void Program(){

        String print;
        ArrayList<Double> list = new ArrayList<>();
        try(BufferedReader test = new BufferedReader(
                new FileReader("Objektorienterad/src/Sprint2/Uppgift8/temp.txt"))) {

            while ((print = test.readLine()) != null) {
                double a = parseDoubleValue(print);
                list.add(a);
            }
        }catch (Exception e){
            System.out.println("Error");
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
    public double parseDoubleValue(String val){
        return Double.parseDouble(val.replaceAll(",", "."));
    }

    public static void main(String[] args) throws IOException {
        ReaderA r1 = new ReaderA();
        r1.Program();
    }


}
