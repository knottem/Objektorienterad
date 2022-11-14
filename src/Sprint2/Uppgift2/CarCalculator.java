package Sprint2.Uppgift2;

import javax.swing.*;

public class CarCalculator {

    public void Program(){
        double meterSetting = Double.parseDouble(JOptionPane.showInputDialog("Ange mätarställning: ").trim());
        double meterSettingLastYear = Double.parseDouble(JOptionPane.showInputDialog("Ange mätarställning för ett år sen: ").trim());
        double gasUsed = Double.parseDouble(JOptionPane.showInputDialog("Ange bensinförbrukning under året: ").trim());

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