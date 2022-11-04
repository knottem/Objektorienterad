package Sprint3.Uppgift13;

public class Medicine extends Thread{

    private final String text;
    private final int timeSeconds;

    public Medicine(String text, int timeSeconds) {
        this.text = text;
        this.timeSeconds = timeSeconds * 1000;
    }

    @Override
    public void run() {
        System.out.println("Ta din medicin " + text + " nu");
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(timeSeconds);
                System.out.println("Ta din medicin " + text + " nu");
            } catch (InterruptedException e) {
                System.out.println("Medicin: " + text + " klar");
                break;
            }
        }
    }
}
