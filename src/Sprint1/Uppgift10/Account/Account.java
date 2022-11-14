package Sprint1.Uppgift10.Account;

public class Account {

    private int balance;
    private double interest;

    public Account(int balance, double interest){
        this.balance = balance;
        this.interest = interest;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int balance) {
        this.balance += balance;
    }
    public void withdraw(int balance) {
        this.balance -= balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
