class FullTimeEmployee extends Employee {

    private double annualBonus;

    public FullTimeEmployee(
            String employeeId,
            String firstName,
            String lastName,
            double annualBonus,
            double baseSalary,
            BankAccount bankAccount) {
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