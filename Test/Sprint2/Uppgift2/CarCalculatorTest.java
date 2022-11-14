package Sprint2.Uppgift2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCalculatorTest {

    CarCalculator carCalculator = new CarCalculator();


    @Test
    void calculateDistanceDrivenDuringLastYear() {
        double meterSetting = 1890;
        double meterSettingLastYear = 950;
        double test = carCalculator.calculateDistanceDrivenDuringLastYear(meterSetting,meterSettingLastYear);
        assertEquals(940,test);

    }

    @Test
    void calculateAverageGasUsage() {
        double gasUsedLastYear = 1500;
        double distanceDrivenLastYear = 1000;
        double test = carCalculator.calculateAverageGasUsage(gasUsedLastYear,distanceDrivenLastYear);
        assertEquals(1.5, test);

    }

    @Test
    void printAll() {
        String s1 = carCalculator.printDistanceDriven(1000);
        String s2 = carCalculator.printGas(500);
        String s3 = carCalculator.printCPM(2);

        assertEquals("Antal körda mil: 1000.0", s1);
        assertEquals("Antal liter bensin: 500.0", s2);
        assertEquals("Förbrukning per mil: 2.0", s3);

    }

}