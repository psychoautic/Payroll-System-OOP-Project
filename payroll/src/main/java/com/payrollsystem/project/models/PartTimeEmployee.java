package com.payrollsystem.project.models;

import com.payrollsystem.project.models.Employee;

class PartTimeEmployee extends Employee {

    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(int employeeId, String firstName, String lastName, double baseSalary,
            BankAccount bankAccount, double hourlyRate, int hoursWorked,
            String bankName, int bankNumber, String iban, String swiftCode) {

        super(employeeId, firstName, lastName, baseSalary, bankName, bankNumber, iban, swiftCode);
        this.hourlyRate = hourlyRate;
        super.setType("Part-Time");
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override

    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override

    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Pay: " + calculatePay());
    }
}
