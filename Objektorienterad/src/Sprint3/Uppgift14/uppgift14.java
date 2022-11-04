package Sprint3.Uppgift14;

import javax.swing.*;
import java.util.ArrayList;

public class uppgift14 {

    static ArrayList<Producer> producers = new ArrayList<>();
    static ArrayList<Consumer> consumers = new ArrayList<>();
    static int time, priority;
    static Integer[] priorityNumbers = {1,2,3,4,5,6,7,8,9,10};
    static String name;
    static MyQueue myQueue = new MyQueue();

    public static void main(String[] args) throws InterruptedException {

        /*
        int producenterLength = Integer.parseInt(JOptionPane.showInputDialog("Hur många producenter?"));
        for (int i = 0; i < producenterLength; i++) {
            int j = i+1;
            name = JOptionPane.showInputDialog("Vad vill du lägga in? för producent " + j);
            time = Integer.parseInt(JOptionPane.showInputDialog("Hur ofta i sekunder? för producent " + j));
            priority = (int) JOptionPane.showInputDialog(null, "Vilken prioritet ska den ha?",
                    "Prioritet", JOptionPane.QUESTION_MESSAGE, null, priorityNumbers, priorityNumbers[0]);
            producers.add(new Producer(name,time, myQueue, priority));
        }
        int consumerLength = Integer.parseInt(JOptionPane.showInputDialog("Hur många Konsumenter?"));
        for (int i = 0; i < consumerLength; i++) {
            int j = i+1;
            time = Integer.parseInt(JOptionPane.showInputDialog("Hur ofta i sekunder? för konsument " + j));
            consumers.add(new Consumer(time, myQueue));
        }

         */

        producers.add(new Producer("äpple", 1,myQueue,10));
        producers.add(new Producer("banan", 2,myQueue,1));
        producers.add(new Producer("test3", 2,myQueue,9));
        consumers.add(new Consumer(2,myQueue));
        consumers.add(new Consumer(2,myQueue));

        for (Producer producer : producers) {
            producer.start();
        }

        for (Consumer consumer : consumers) {
            consumer.start();
        }


        Thread.sleep(15000);

        System.out.println("Antal kvar i kön "+ myQueue.size());
        myQueue.printQueue();
        System.exit(0);

    }
}
