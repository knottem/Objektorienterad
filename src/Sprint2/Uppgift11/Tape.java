package Sprint2.Uppgift11;

import java.time.Duration;

public class Tape {

    private Duration length;
    private Duration totalLength;
    private Duration usedLength;

    public Tape(Duration totalLength, Duration usedLength) {
        this.totalLength = totalLength;
        this.usedLength = usedLength;
        this.length = totalLength.minus(usedLength);
    }

    public Duration getLength() {
        return length;
    }

}
