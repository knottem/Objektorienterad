package Sprint2.Uppgift10;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeWorldTest {

    TimeWorld t1 = new TimeWorld();
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    @Test
    public void convertTextTest(){
        String s1 = "   Apa";
        String s2 = "GeOrGe   ";
        assertEquals("apa", t1.convertText(s1));
        assertEquals("george", t1.convertText(s2));
    }
    @Test
    public void showTimeTest(){
        String s1 = "stockholm";
        String s2 = "toronto";
        t1.showTime(s1);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY)+2, t1.hours);
        t1.showTime(s2);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY)-4, t1.hours);


    }

}
