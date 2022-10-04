package Sprint1.Uppgift10.Person;

public class Employee extends Person{

    final private int employeeID;
    private int salary;

    public Employee(String name, int ID, int employeeID, int salary) {
        super(name, ID);
        this.employeeID = employeeID;
        this.salary = salary;
    }
    public void salaryRise(int rise){
        salary += rise;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getSalary() {
        return salary;
    }
}
