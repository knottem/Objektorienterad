package Sprint2.Uppgift11;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class VideoTest {
    Video v1 = new Video();

    @Test
    public void checkIfTapeFitsTest(){
        LocalTime start = LocalTime.of(10,20,0);
        LocalTime end = LocalTime.of(11,0,0);

        Duration durTotalLength = Duration.ofMinutes(180);
        Duration durUsedLength = Duration.ofMinutes(140);
        Program p1 = new Program(start, end);
        Tape t1 = new Tape(durTotalLength, durUsedLength);

        assertTrue(v1.checkIfTapeFits(t1.getLength(), p1.getLength()));

        LocalTime end2 = LocalTime.of(11,20,0);
        Program p2 = new Program(start, end2);

        assertFalse(v1.checkIfTapeFits(t1.getLength(), p2.getLength()));

    }
    @Test
    public void ProgramTest(){
        LocalTime start = LocalTime.of(10,20,0);
        LocalTime end = LocalTime.of(11,0,0);
        Duration dur = Duration.ofMinutes(40);
        Duration dur2 = Duration.ofMinutes(60);
        Program p1 = new Program(start, end);

        assertEquals(p1.getLength(), dur);
        assertNotEquals(p1.getLength(), dur2);
    }
    @Test
    public void TapeTest() {
        Duration durTotalLength = Duration.ofMinutes(180);
        Duration durUsedLength = Duration.ofMinutes(140);
        Duration dur = Duration.ofMinutes(40);
        Duration dur2 = Duration.ofMinutes(60);

        Tape t1 = new Tape(durTotalLength, durUsedLength);

        assertEquals(t1.getLength(), dur);
        assertNotEquals(t1.getLength(), dur2);
    }
}
