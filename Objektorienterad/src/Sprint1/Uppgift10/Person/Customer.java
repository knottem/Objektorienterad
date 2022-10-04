package Sprint1.Uppgift10.Person;
import Sprint1.Uppgift10.Account.Account;
import Sprint1.Uppgift10.Account.Loan;
import java.util.ArrayList;

public class Customer extends Person{

    private final int customerID;
    private ArrayList<Account> accounts;
    private ArrayList<Loan> loans;

    public Customer(String name, int ID, int customerID, Account account) {
        super(name, ID);
        this.customerID = customerID;

        loans = new ArrayList<>();
        accounts = new ArrayList<>();
        accounts.add(account);
    }
    public void newLoan(Loan loan){
        loans.add(loan);
    }
    public void newAccount(Account account){
        accounts.add(account);
    }
}
