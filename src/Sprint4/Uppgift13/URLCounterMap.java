package Sprint4.Uppgift13;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class URLCounterMap {

    static String inputLine;
    static int count = 0;


    public void Counter() throws IOException {

        URL test = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");
        InetAddress address = InetAddress.getByName(test.getHost());
        Map<Integer, Integer> mapper = new HashMap<>();



        try(BufferedReader in = new BufferedReader(new InputStreamReader(test.openStream()))) {
            while ((inputLine = in.readLine()) != null) {
                int size = inputLine.length();
                mapper.merge(size, 1, Integer::sum);
                count++;
            }
        }

        for (Map.Entry<Integer,Integer> entry : mapper.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        System.out.println("\nTotalt antal ord\n" + count);
        System.out.println("\nHämtad från ip " + address.getHostAddress());



    }

    public static void main(String[] args) throws IOException {
        URLCounterMap urlCounterMap = new URLCounterMap();
        urlCounterMap.Counter();
    }


}