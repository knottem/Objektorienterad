package HederligeHarrydel1;

public class Hederligeharry1 {


    public Hederligeharry1() {

        BilAnnons b1 = new BilAnnons(20000, "Volvo V70", "En grym volvo som är helt perfekt", 1996, 200000, "grön", true, true);
        HusvagnsAnnons h1 = new HusvagnsAnnons(150000, "Husvagn", "En stor och trasig husvagn", 2009, 25000, false, 4);
        MotorCykelAnnons m1 = new MotorCykelAnnons(15000, "Harley Davidson", "en motorcykel", 1999, 3999, 25000, "kedja");

        System.out.println(b1.getAnnonsText());
        System.out.println(h1.getAnnonsText());
        System.out.println(m1.getAnnonsText());

    }

    public static void main(String[] args) {
        new Hederligeharry1();
    }


}
