package Sprint4.Uppgift15;

public interface IQueue<T> {
    void put(T t);
    T take();
    int size();

    void printAll();
}
