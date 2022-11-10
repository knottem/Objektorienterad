package Sprint4.Uppgift13;


import java.io.*;
import java.net.URL;

public class URLCounter {

    static String inputLine;
    static int count = 0;


    public void Counter() throws IOException {

        URL test = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");

        try(BufferedReader in = new BufferedReader(new InputStreamReader(test.openStream()))) {

            while ((inputLine = in.readLine()) != null) {
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws IOException {
        URLCounter urlCounter = new URLCounter();
        urlCounter.Counter();
    }


}
