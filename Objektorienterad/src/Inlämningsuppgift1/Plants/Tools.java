package Inlämningsuppgift1.Plants;

import Inlämningsuppgift1.Plants.Plants;

import javax.swing.*;

public interface Tools {

    default double convertLToCl(double amount){
        double converted = amount * 100;
        return converted;
    }

    static void joptShowMessage(Plants plant){
            JOptionPane.showMessageDialog(null, "Din planta " + plant.getName() + " behöver dagligen:\n"
                    + plant.calculateLiquid() + " Liter " + plant.getLiquidType() + "\n"
                    + plant.convertLToCl(plant.calculateLiquid()) + " Cl " + plant.getLiquidType());
    }

}

