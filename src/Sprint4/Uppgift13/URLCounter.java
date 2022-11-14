package Sprint4.Uppgift13;


import java.io.*;
import java.net.InetAddress;
import java.net.URL;

public class URLCounter {

    static String inputLine;
    static int count = 0;
    int[] wordsSize = new int[50];
    String biggestWord, smallestWord;
    int maxSize = 0;
    int smallestSize = 100;

    public void Counter() throws IOException {

        URL test = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");
        InetAddress address = InetAddress.getByName(test.getHost());

        try(BufferedReader in = new BufferedReader(new InputStreamReader(test.openStream()))) {
            while ((inputLine = in.readLine()) != null) {

                    if(inputLine.length() > maxSize){
                        maxSize = inputLine.length();
                        biggestWord = inputLine;
                    }
                    if(inputLine.startsWith("b")) {
                        if (inputLine.length() < smallestSize) {
                            smallestSize = inputLine.length();
                            smallestWord = inputLine;
                        }
                    }
                    wordsSize[inputLine.length()]++;
                    count++;
            }
        }
        for (int i = 0; i < wordsSize.length; i++) {
            if(wordsSize[i] != 0) {
                System.out.println("Antal ord med storleken " + i + " är " + wordsSize[i]);
            }
        }

        System.out.println("\nTotalt antal ord\n" + count);
        System.out.println("\nHämtad från ip " + address.getHostAddress());

        System.out.println("\nLängsta ordet \n" + biggestWord);
        System.out.println("\nFörsta kortaste ordet som börjar på b är\n" + smallestWord);


    }

    public static void main(String[] args) throws IOException {
        URLCounter urlCounter = new URLCounter();
        urlCounter.Counter();
    }


}
