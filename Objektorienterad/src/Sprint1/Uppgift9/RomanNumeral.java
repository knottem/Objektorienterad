package Sprint1.Uppgift9;

public enum RomanNumeral {
    I("one", 1),
    V("five", 5),
    X("ten", 10),
    L("fifty", 50),
    C("a hundred", 100),
    D("fivehundred", 500),
    M("a thousand", 1000)
    ;

    private final String numeral;
    private final int number;

    RomanNumeral(String numeral, int number) {
        this.numeral = numeral;
        this.number = number;
    }

    public String getNumeral() {
          return numeral;
      }

      public int getNumber() {
          return number;
      }

}
