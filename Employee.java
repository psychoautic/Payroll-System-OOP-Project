import java.util.List;
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private double baseSalary;
    private BankAccount bankAccount;
    private List<Shift> assignedShifts;

    public Employee(int employeeId, String firstName, String lastName, double baseSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
        // this.bankAccount = bankAccount;
        this.assignedShifts = new java.util.ArrayList<>();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double calculatePay() {
        return baseSalary;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Base Salary: " + baseSalary);
    }

    public void addShift(Shift s) {
        this.assignedShifts.add(s); 
    }

}
