package Sprint4.Demo.URLdemo;

import java.net.*;

public class URLDemo {
    public static void main(String[] args) throws Exception {

        URL aURL = new URL("http://www.example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING");

        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());

        if (aURL.getProtocol().equals("http")) {
            System.out.println("Detta är en http server");
        }
    }

}
