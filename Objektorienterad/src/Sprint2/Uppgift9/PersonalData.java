package Sprint2.Uppgift9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalData{
    ArrayList<Person> personal = new ArrayList<>();
    ArrayList<Person> personal2;
    String filepath = "Objektorienterad/src/Sprint2/Uppgift9/Personuppgifter.txt";
    String filepath2 = "Objektorienterad/src/Sprint2/Uppgift9/Personuppgifterlanga.txt";
    public void Program() throws IOException {

        addPersonal(personal, filepath);
        printPerson(personal);

        System.out.println("----------");

        personal2 = checkTallest(personal);
        printPerson(personal2);
        createFile(personal2, filepath2);
    }
    public ArrayList<Person> checkTallest(ArrayList<Person> personal){
        ArrayList<Person> height = new ArrayList<>();
        for (Person person : personal) {
            if (person.length >= 200) {
                height.add(person);
            }
        }
        return height;
    }

    public void printPerson(ArrayList<Person> personal){
        for (Person person : personal) {
            System.out.println("Namn: " + person.namn + " Adress:" +
                    person.adress + " Postnr: " + person.postnr);
            System.out.println("Ålder: " + person.age + " Vikt: " + person.weight +
                    " Längd: " + person.length + "\n");
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
            writer = new FileWriter(filepath, false);
            for (Person person : personal) {
                writer.write("Namn: " + person.namn + " Adress:" +
                        person.adress + " Postnr: " + person.postnr + "\n");
                writer.write("Ålder: " + person.age + " Vikt: " + person.weight +
                        " Längd: " + person.length + "\n\n");
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
