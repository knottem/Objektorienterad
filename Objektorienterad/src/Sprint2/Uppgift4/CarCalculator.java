package Sprint2.Uppgift4;

import java.util.Scanner;

public class CarCalculator {

    public void Program(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Ange mätarställning:");
        double meterSetting = scan.nextDouble();
        System.out.println("Ange mätarställning för ett år sen:");
        double meterSettingLastYear = scan.nextDouble();
        System.out.println("Ange bensinförbrukning under året:");
        double gasUsed = scan.nextDouble();

        double distanceDrivenYear = calculateDistanceDrivenDuringLastYear(meterSetting, meterSettingLastYear);
        double CPM = calculateAverageGasUsage(distanceDrivenYear, gasUsed);

        System.out.println(printDistanceDriven(distanceDrivenYear));
        System.out.println(printGas(gasUsed));
        System.out.println(printCPM(CPM));
    }

    public double calculateDistanceDrivenDuringLastYear(double meterSetting, double meterSettingLastYear){
        return meterSetting - meterSettingLastYear;
    }

    public double calculateAverageGasUsage(double gasUsedLastYear, double distanceDrivenLastYear){
        return gasUsedLastYear / distanceDrivenLastYear;
    }

    public String printDistanceDriven(double distanceDriven){
        return "Antal körda mil: " + distanceDriven;
    }

    public String printGas(double gasUsed){
        return "Antal liter bensin: " + gasUsed;
    }

    public String printCPM(double averageGas){
        return "Förbrukning per mil: " + averageGas;
    }

    public static void main(String [] args){

        CarCalculator carCalculator = new CarCalculator();
        carCalculator.Program();

    }


}