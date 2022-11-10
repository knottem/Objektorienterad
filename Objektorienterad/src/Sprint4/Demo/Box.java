package Sprint4.Demo;

public class Box<T> { // T stands for "Type"

    private T t;

    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Number> b = new Box<>();
        b.set(10);
        System.out.println(b.get());
        b.set(20.0);
        System.out.println(b.get());

        Box<String> b2 = new Box<>();
        b2.set("test");
        System.out.println(b2.get());

        String[] s = new String[3];
        s[0] = "hej";
        s[1] = "asd";
        s[2] = "ads";
        for (String value : s) {
            System.out.println(value);

        }

    }
}