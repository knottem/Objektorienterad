package Sprint2.Uppgift7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import Tools.Tools;

public class Interest extends Tools{

    final double interest = 1.1;

    public void Program(){

        double sum = inputDouble("Hur mycket ska du spara?");
        int year = inputInt("Hur många år?");

        System.out.println("År                Sum");
        System.out.println("---------------------");
        for (int i = 0; i < year; i++) {
            System.out.printf("%2d%15.2f kr\n", i, calculateInterest(sum,interest,i));
        }


    }

    public double calculateInterest(double sum, double interest, int year){

        for (int i = 1; i <= year; i++) {
            sum = sum * interest;
        }
        BigDecimal sum1 = BigDecimal.valueOf(sum).setScale(2,RoundingMode.HALF_UP);
        return sum1.doubleValue();
    }


    public static void main(String[] args) {
        Interest i1 = new Interest();
        i1.Program();
    }

}
