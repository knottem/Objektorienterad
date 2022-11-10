package Sprint4.Uppgift13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class URLCounterStream {

    public void Test() throws IOException {
        URL test = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");

        new BufferedReader(new InputStreamReader(test.openStream())).lines().collect(
                Collectors.groupingBy(String::length)).forEach((k, v) -> System.out.println(k + " " + v.size()));
    }

    public static void main(String[] args) throws IOException {
        URLCounterStream a = new URLCounterStream();
        a.Test();
    }
}
