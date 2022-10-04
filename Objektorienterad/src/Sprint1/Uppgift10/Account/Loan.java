package Sprint1.Uppgift10.Account;

public class Loan {

    private int amount;
    private double interest;


    public Loan(int amount, double interest) {
        this.amount = amount;
        this.interest = interest;
    }

    public int getAmount() {
        return amount;
    }

    public double getInterest() {
        return interest;
    }
    public void setInterest(double interest){
        this.interest = interest;
    }
    public void amortise(int amount){
        this.amount -= amount;
    }
}
