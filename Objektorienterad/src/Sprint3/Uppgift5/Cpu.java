package Sprint3.Uppgift5;

public class Cpu {
    private static final String name = "CPU";
    private int score = 0;

    public Cpu() {
    }

    public int getScore() {
        return score;
    }

    public static String getName() {
        return name;
    }

    public void setScore() {
        score++;
    }
}