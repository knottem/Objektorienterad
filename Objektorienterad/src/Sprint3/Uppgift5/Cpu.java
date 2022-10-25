package Sprint3.Uppgift5;

public class Cpu {
    private int score = 0;

    public Cpu() {
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return "CPU";
    }

    public void setScore() {
        score++;
    }
}