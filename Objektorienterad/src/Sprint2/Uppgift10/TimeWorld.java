package Sprint2.Uppgift10;
import Tools.Tools;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

public class TimeWorld extends Tools {

    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    NumberFormat formatter = new DecimalFormat("00");
    public int hours;
    boolean repeat;
    public void Program(){

        do {
            System.out.println("Vilken stad vill du kolla tiden på? (Stockholm, Shanghai,Toronto, Tokyo)");
            String answer;
            try {
                Scanner scan = new Scanner(System.in);
                answer = scan.nextLine();
                String answer2 = convertText(answer);
                showTime(answer2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (hours != -1) {
                printTime();
            }
             repeat = repeatProgram("Kör igen?");
        }while(!repeat);
    }

    public String convertText(String text){
        String text1 = text.replaceAll("\\s+","");
        return text1.toLowerCase();
    }

    public void showTime(String city){
        switch (city) {
            case "toronto" -> hours = cal.get(Calendar.HOUR_OF_DAY)-4;
            case "stockholm","berlin" -> hours = cal.get(Calendar.HOUR_OF_DAY)+2;
            case "shanghai" -> hours = cal.get(Calendar.HOUR_OF_DAY)+8;
            case "tokyo" -> hours = cal.get(Calendar.HOUR_OF_DAY)+9;
            case "chicago" -> hours = cal.get(Calendar.HOUR_OF_DAY)-5;
            default -> {
                System.out.println("Den Staden finns inte inlagd");
                hours = -1;
            }
        }
    }

    public void printTime(){
        System.out.println(formatter.format(hours) + ":" + formatter.format(cal.get(Calendar.MINUTE))
                + ":"+ formatter.format(cal.get(Calendar.SECOND)));
    }


    public static void main(String[] args) {
        TimeWorld t1 = new TimeWorld();
        t1.Program();
    }
}
