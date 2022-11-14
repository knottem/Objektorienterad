package Sprint3.Demo.ThreadDemo;

public class Skrivare extends Thread{
    private final String text;
    private final long interval;

    public Skrivare(String text, long interval){
        this.text = text;
        this.interval = interval * 1000;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(interval);
                System.out.println(text);
            } catch (InterruptedException e) {
                System.out.println("interrupted exception slängdes");
                break;
            }
        }
    }
}
