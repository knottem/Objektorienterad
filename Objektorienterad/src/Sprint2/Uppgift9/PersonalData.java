package Sprint2.Uppgift9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PersonalData{
    public void Program() throws IOException {

        ArrayList<Person> personal = new ArrayList<>();
        String filepath = "Objektorienterad/src/Sprint2/Uppgift9/Personuppgifter.txt";
        String filepath2 = "Objektorienterad/src/Sprint2/Uppgift9/Personuppgifterlanga.txt";
        addPersonal(personal, filepath);
        ArrayList<Person> personal2;
        personal2 = checkTallest(personal);
        printPerson(personal);
        System.out.println("----------");
        printPerson(personal2);
        createFile(personal2, filepath2);
    }
    public ArrayList<Person> checkTallest(ArrayList<Person> personal){
        ArrayList<Person> height = new ArrayList<>();
        for (int i = 0; i < personal.size(); i++) {
            if(personal.get(i).length >= 200) {
               height.add(personal.get(i));
            }
        }
        return height;
    }

    public void printPerson(ArrayList<Person> personal){
        for (int i = 0; i < personal.size(); i++) {
            System.out.println("Namn: " + personal.get(i).namn + " Adress:" +
                    personal.get(i).adress + " Postnr: " + personal.get(i).postnr);
            System.out.println("Ålder: " + personal.get(i).age + " Vikt: " + personal.get(i).weight +
                    " Längd: " + personal.get(i).length + "\n");
        }

    }
    public void addPersonal(ArrayList<Person> personal, String filepath){
        String firstLine;
        String secondLine;
        String[] dataFirst;
        String[] dataSecond = new String[3];
        try(Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNext()) {
                firstLine = scanner.nextLine();
                dataFirst = firstLine.split(",");
                if (scanner.hasNext()) {
                    secondLine = scanner.nextLine();
                    dataSecond = secondLine.split(", ");
                }

                int[] dataNum = new int[dataSecond.length];

                for (int i = 0; i < dataSecond.length; i++) {
                    dataNum[i] = Integer.parseInt(dataSecond[i]);
                }
                personal.add(new Person(dataFirst[0], dataFirst[1],dataFirst[2], dataNum[0], dataNum[1], dataNum[2]));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void createFile(ArrayList<Person> personal, String filepath ) throws IOException {
        FileWriter writer;
        try {
            writer = new FileWriter(filepath, true);
            for (int i = 0; i < personal.size(); i++) {
                writer.write("Namn: " + personal.get(i).namn + " Adress:" +
                        personal.get(i).adress + " Postnr: " + personal.get(i).postnr);
                writer.write("Ålder: " + personal.get(i).age + " Vikt: " + personal.get(i).weight +
                        " Längd: " + personal.get(i).length + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.close();
    }


    public static void main(String[] args) throws IOException {
        PersonalData p1 = new PersonalData();
        p1.Program();
    }
}
