package Sprint2.Uppgift3;

import java.util.Objects;
import java.util.Scanner;

public class Mocking {

    public static void main(String[] args) {
        Mocking mocking = new Mocking();
        mocking.Program();
    }

    public void Program(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv något: ");

        while(true) {
                String s1 = scan.nextLine();
                System.out.println("Du skrev: " + s1);

                if(Objects.equals(s1, "exit")){
                    break;
                }
        }

    }
}
