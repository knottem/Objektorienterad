package Sprint2.Uppgift13;

import java.util.Scanner;
public class Kalkylator extends calculates{


    public void programmet() throws operatorNotSupportedException {

        System.out.println("Kalkylator: ");
        String sum;
        try (Scanner input = new Scanner(System.in)) {
            sum = input.nextLine();
            if (isOperatorCorrect(sum)) {
                String operator = operatorVal(sum);
                double num1 = num1(sum);
                double num2 = num2(sum);
                System.out.println(calculate(sum, operator, num1, num2));
            }
        } catch (operatorNotSupportedException e) {
            throw new operatorNotSupportedException();
        }

    }


    public static void main(String[] args) throws Throwable{
        Kalkylator kalkylator = new Kalkylator();
        kalkylator.programmet();
    }




}
