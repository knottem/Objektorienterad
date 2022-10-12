package Sprint2.Uppgift8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {


    public void Program() throws IOException {

        String print;
        BufferedReader test = new BufferedReader(new FileReader("Objektorienterad/src/Sprint2/Uppgift8/temp.txt"));

        while((print = test.readLine()) != null){
            System.out.println(print);
        }

    }

    public static void main(String[] args) throws IOException {
        Reader r1 = new Reader();
        r1.Program();
    }
}
