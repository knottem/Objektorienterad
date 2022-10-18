package Sprint2.Uppgift11;

import java.time.Duration;
import java.time.LocalTime;

public class Program {
    private Duration length;
    private LocalTime startTime;
    private LocalTime endTime;

    public Program(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.length = Duration.between(startTime, endTime);
    }

    public Duration getLength() {
        return length;
    }

}
