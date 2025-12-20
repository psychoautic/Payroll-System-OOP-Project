package com.payrollsystem.project.models;

import com.payrollsystem.project.models.Employee;

public class FullTimeEmployee extends Employee {

    private double annualBonus;

    public FullTimeEmployee() {

    }

    public FullTimeEmployee(int employeeId, String firstName, String lastName,
            double annualBonus, double baseSalary, String bankName, int bankNumber, String iban, String swiftCode) {

        super(employeeId, firstName, lastName, baseSalary, bankName, bankNumber, iban, swiftCode);
        this.annualBonus = annualBonus;
        super.setType("Full-Time");
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double annualBonus) {
        this.annualBonus = annualBonus;
    }

    @Override

    public double calculatePay() {
        return (getBaseSalary() * annualBonus) + getBaseSalary();
    }

    @Override

    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Annual Bonus: " + annualBonus);
        System.out.println("Total Pay: " + calculatePay());
    }
}