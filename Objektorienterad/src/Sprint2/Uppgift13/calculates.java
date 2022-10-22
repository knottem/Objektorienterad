package Sprint2.Uppgift13;
public class calculates {

    public double num1(String sum) throws operatorNotSupportedException {
        String operator;
        String sum2;

        if (sum.charAt(0) == '-') {
            sum2 = sum.substring(1);
            operator = operatorVal(sum2);
            try {
               return Double.parseDouble(sum2.substring(0, sum2.indexOf(operator)));
            } catch (NumberFormatException e) {
                throw new operatorNotSupportedException();
            }
        }
        else {
            operator = operatorVal(sum);

            try {
                return Double.parseDouble(sum.substring(0, sum.indexOf(operator)));
            } catch (NumberFormatException e) {
                throw new operatorNotSupportedException();
            }
        }
    }
    public double num2(String sum) throws operatorNotSupportedException {
        String sum2;
        String operator;

        if (sum.charAt(0) == '-') {
            sum2 = sum.substring(1);
            operator = operatorVal(sum2);
            try {
                return Double.parseDouble(sum2.substring(sum2.indexOf(operator) + 1));
            } catch (NumberFormatException e) {
                throw new operatorNotSupportedException();
            }
        } else {
            operator = operatorVal(sum);
            try {
                return Double.parseDouble(sum.substring(sum.indexOf(operator) + 1));
            } catch (NumberFormatException e) {
                throw new operatorNotSupportedException();
            }
        }
    }

    public double calculate(String sum, String operator, double num1, double num2) {
        switch(operator)
        {
            case "+" -> {
                if (sum.charAt(0) == '-') {
                    return (-1 * num1) + num2;
                } else {
                    return num1 + num2;
                }
            }

            case "-" -> {
                if (sum.charAt(0) == '-') {
                    return -1 * num1 - num2;
                } else {
                    return num1 - num2;
                }
            }

            case "*" -> {
                if (sum.charAt(0) == '-') {
                    return (-1 * num1) * num2;
                } else {
                    return (num1 * num2);
                }
            }

            case "/" -> {
                if (num2 == 0) {
                    return 0;
                } else if (sum.charAt(0) == '-') {
                    return (-1 * num1) / num2;
                } else {
                    return num1 / num2;
                }
            }
            default -> System.out.println("Felaktigt");
        }
        return 0;
    }

    public String operatorVal(String sum){
        sum = sum.substring(1);
        String operator = "";
        if (sum.contains("-")) {
            operator = "-";
        } else if (sum.contains("+")) {
            operator = "+";
        } else if (sum.contains("*")) {
            operator = "*";
        } else if (sum.contains("/")) {
            operator = "/";
        }
        return operator;
    }

    public boolean isOperatorCorrect(String sum) {

        boolean test = true;

        int antalminus = antalTecken(sum, "-");
        int antalplus = antalTecken(sum, "+");
        int antalganger = antalTecken(sum, "*");
        int antaldelat = antalTecken(sum, "/");

        if (sum.isEmpty()) {
            System.out.println("Uttrycket får inte vara tomt");
            test = false;
        } else if (sum.contains(",")) {
            System.out.println("Inga komma tecken");
            test = false;
        } else if (sum.contains("%")) {
            System.out.println("Inga Procent tal.");
            test = false;
        } else if (sum.charAt(0) == '*') {
            System.out.println("Du Kan ej starta tal med *");
            test = false;
        } else if (sum.charAt(0) == '/') {
            System.out.println("Du Kan ej starta tal med /");
            test = false;
        } else if (antalminus > 2) {
            System.out.println("Du kan ej ha med fler operatör: -");
            test = false;
        } else if (antalplus > 1) {
            System.out.println("Du kan ej ha med fler operatör: +");
            test = false;
        } else if (antalganger > 1) {
            System.out.println("Du kan ej ha med fler operatör: *");
            test = false;
        } else if (antaldelat > 1) {
            System.out.println("Du kan ej ha med fler operatör: /");
            test = false;
        } else if (antalminus == 0 && antalplus == 0 && antaldelat == 0 && antalganger == 0) {
            System.out.println("Du kan ej starta programmet utan operator");
            test = false;
        } else if (antalminus == 2) {
            if (antaldelat == 1) {
                System.out.println("Du kan ej ha med fler operatör: --/");
                test = false;
            } else if (antalganger == 1) {
                System.out.println("Du kan ej ha med fler operatör: --*");
                test = false;
            } else if (antalplus == 1) {
                System.out.println("Du kan ej ha med fler operatör: --+");
                test = false;
            }
        }

        return test;
    }
    public int antalTecken(String nr1, String nr2) {
        int antal = 0;
        for (int i = 0; i < nr1.length(); i = i + 1) {
            if (nr1.charAt(i) == nr2.charAt(0)) {
                antal = antal + 1;
            }
        }
        return antal;
    }
}
