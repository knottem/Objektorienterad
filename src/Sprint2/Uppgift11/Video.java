package Sprint2.Uppgift11;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Video {



    public void huvudProgram(){
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("Hur långt är ditt videoband totalt i minuter?");
            int totalTid = scan.nextInt();
            Duration totalTime = Duration.ofMinutes(totalTid);

            System.out.println("Hur mycket tid har du använt på ditt videoband i minuter?");

            int tid = scan.nextInt();
            Duration minutes = Duration.ofMinutes(tid);

            Tape t1 = new Tape(totalTime, minutes);

            System.out.println("Vilken timme börjar programmet?");
            int programStartTimme = scan.nextInt();
            System.out.println("Vilken minut börjar programmet?");
            int programStartMinuter = scan.nextInt();

            LocalTime programStart = LocalTime.of(programStartTimme, programStartMinuter, 0);

            System.out.println("Vilken timme slutar programmet?");
            int programSlutTimme = scan.nextInt();
            System.out.println("Vilken minut slutar programmet?");
            int programTidMinuter = scan.nextInt();

            LocalTime programSlut = LocalTime.of(programSlutTimme, programTidMinuter, 0);

            Program p1 = new Program(programStart, programSlut);

            boolean test = checkIfTapeFits(t1.getLength(), p1.getLength());
            if (test) {
                System.out.println("Du får plats med programmet.");
            } else {
                System.out.println("Du får inte plats med programmet");
            }
        }catch(Exception e){
            System.out.println("Något blev fel");
        }



    }

    public boolean checkIfTapeFits(Duration TapeDuration, Duration ProgramDuration){
        int i = TapeDuration.compareTo(ProgramDuration);
        if(i >= 0){
            return true;
        }
        else{
            return false;
        }

    }
    public static void main(String[] args) {
        Video v1 = new Video();
        v1.huvudProgram();
    }

}
