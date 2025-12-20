package com.payrollsystem.project.models;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private double baseSalary;
    private BankAccount bankAccount;
    private String type;
    private boolean payStatus;

    public Employee() {

    }

    public Employee(int employeeId, String firstName, String lastName,
            double baseSalary, String bankName, int bankNumber, String iban, String swiftCode) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
        this.type = "No Type";
        this.payStatus = false;
        this.bankAccount = new BankAccount(bankName, bankNumber, iban, swiftCode);
    }

    public boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(boolean payStatus) {
        this.payStatus = payStatus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

}
