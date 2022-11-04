package Sprint4.Uppgift0;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Uppgift0 {

    public static void main(String[] args) throws UnknownHostException {


        System.out.println(Inet4Address.getLocalHost().getHostAddress());
    }
}