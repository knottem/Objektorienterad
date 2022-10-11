package Sprint2.Uppgift6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Change {

    int[] values = {1000,500,200,100,50,20,10,5,2,1};
    StringBuilder sb = new StringBuilder();

    public void Program(){

        int cost = input("How much did it cost?");
        int payed = input("How much did you pay?");
        int change = getChange(cost, payed);

        printAll(change);

    }

    public int getChange(int cost, int payed){
        return payed - cost;
    }

    public int getValueAmount(int change, int value){
        return change / value;
    }

    public int removeLargestValue(int change, int value, int getValueAmount){
        return change - getValueAmount * value;
    }

    public String type(int value){
        if(value >= 20){
            return "lappar";
        }
        else{
            return "kronor";
        }
    }

    public void printAll(int change){
        for(int i= 0; i < values.length; i++){
            int value = values[i];
            int valueAmount = getValueAmount(change, value);
            if(valueAmount >= 1) {
                System.out.println(valueText(valueAmount, value));
            }
            change = removeLargestValue(change, value, valueAmount);
        }
    }

    public String valueText(int valueAmount, int value){

        //return "Antal " + value + "-" + type(value)+ ": " + valueAmount; //Vanlig String
        sb.setLength(0);
        sb.append("Antal "); //ful StringBuilder
        sb.append(value);
        sb.append("-");
        sb.append(type(value));
        sb.append(": ");
        sb.append(valueAmount);
        return sb.toString();
    }

    public int input(String text){
        while(true) {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(text);
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong Type");
                scan.next();
            } catch (NumberFormatException e) {
                System.out.println("Expected a number");
                scan.next();
            }
        }
    }

    public static void main(String[] args) {
        Change c1 = new Change();
        c1.Program();
    }

}
