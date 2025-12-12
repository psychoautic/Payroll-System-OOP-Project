public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double baseSalary;
    private BankAccount bankAccount;

    public Employee(String employeeId, String firstName, String lastName, double baseSalary, BankAccount bankAccount) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
        this.bankAccount = bankAccount;
    }



    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
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

    public BankAccount getBankAccount(){
        return bankAccount;
    }
    public void setBankAccount(BankAccount bankAccount){
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

}

class FullTimeEmployee extends Employee {

    private double annualBonus;

    public FullTimeEmployee(
        String employeeId,
        String firstName,
        String lastName,
        double annualBonus,
        double baseSalary,
        BankAccount bankAccount
    ) {
        super(employeeId, firstName, lastName, baseSalary, bankAccount);
        this.annualBonus = annualBonus;
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double annualBonus) {
        this.annualBonus = annualBonus;
    }

    @Override

    public double calculatePay() {
        return getBaseSalary() + annualBonus;
    }

    @Override

    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Annual Bonus: " + annualBonus);
        System.out.println("Total Pay: " + calculatePay());
    }
}

