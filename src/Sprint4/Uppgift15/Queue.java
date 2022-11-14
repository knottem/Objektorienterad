package Sprint4.Uppgift15;

import java.util.ArrayList;

public class Queue<T> implements IQueue<T> {

    ArrayList<T> queue = new ArrayList<>();

    public Queue() {}

    public void put(T t) {
        queue.add(t);
    }

    public T take(){
        T temp = queue.get(0);
        queue.remove(0);
        return temp;
    }

    public int size(){
        return queue.size();
    }

    @Override
    public void printAll() {
        for (T t : queue) {
            System.out.println(t);
        }
    }
}
