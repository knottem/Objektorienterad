package Inlämningsuppgift1;

import Inlämningsuppgift1.Växter.Plants;

import javax.swing.*;

public interface Tools {

    default double convertToCl(double amount){
        double converted = amount * 100;
        return converted;
    }

    static void joptShowMessage(Plants plant){
            JOptionPane.showMessageDialog(null, "Din planta " + plant.getName() + " behöver dagligen:\n" + plant.calculateLiquid() + " Liter \n" + plant.convertToCl(plant.calculateLiquid()) + " Cl");
    }

}

