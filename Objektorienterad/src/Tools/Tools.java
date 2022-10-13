package Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {

    public int inputInt(String text){
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

    public double inputDouble(String text){
        while(true) {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(text);
                return scan.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Wrong Type");
                scan.next();
            } catch (NumberFormatException e) {
                System.out.println("Expected a number");
                scan.next();
            }
        }
    }
    public boolean repeatProgram(String text) {
        boolean repeat;
        do {
            System.out.println(text +" j/n");
            Scanner input = new Scanner(System.in);
            String yesNo = input.nextLine();
            repeat = true;
            switch (yesNo) {
                case "j" -> repeat = false;
                case "n" -> {
                    System.out.println("Hej då");
                    System.exit(0);
                }
                default -> System.out.println("Svara med j för JA och n för NEJ");
            }
        } while (repeat);
        return false;
    }
}
