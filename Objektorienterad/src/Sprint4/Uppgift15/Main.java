package Sprint4.Uppgift15;


public class Main {

    public static void main(String[] args) {
        Queue<String> test = new Queue<>();
        test.put("hej1");
        test.put("hej2");
        test.put("hej3");
        //test.printAll();



        NumberQueue<Number> test2 = new NumberQueue<>();
        test2.put(1);
        test2.put(2);
        test2.put(3);
        test2.put(2.4);
        System.out.println(test2.sumAll());
        test2.take();
        System.out.println(test2.sumAll());
        test2.take();
        System.out.println(test2.sumAll());
        test2.take();
        System.out.println(test2.sumAll());

        /*
        System.out.println(test2.size());
        System.out.println(test2.take());
        System.out.println(test2.size());
        System.out.println(test2.take());
        System.out.println(test2.size());

         */


    }


}
