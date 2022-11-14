package Sprint4.Uppgift15;

import java.util.ArrayList;

public class NumberQueue<T extends Number> implements IQueue<T> {

    private final ArrayList<T> queue = new ArrayList<>();

    public NumberQueue(){}

    @Override
    public void put(T t) {
        queue.add(t);
    }

    @Override
    public T take() {
        T temp = queue.get(0);
        queue.remove(0);
        return temp;
    }

    @Override
    public int size() {
        return queue.size();
    }
    @Override
    public void printAll() {
        for (T t : queue) {
            System.out.println(t);
        }
    }

    public double sumAll(){
        double sum = 0;
        for (T t : queue) {
            sum += t.doubleValue();
        }
        return sum;
    }

}