package Sprint2.Uppgift1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Figure {

    double getArea();

    double getCircumference();

    default double roundDouble(double value){
        BigDecimal v = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
        return v.doubleValue();
    }
}
