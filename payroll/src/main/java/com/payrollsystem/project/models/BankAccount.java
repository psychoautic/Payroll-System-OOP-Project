package com.payrollsystem.project.models;

public class BankAccount {
    private String bankName;
    private int bankNumber;
    private String Iban;
    private String swift;
    private int balance;

    public BankAccount(String bankName, int bankNumber, String iban, String swiftCode) {
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.Iban = iban;
        this.swift = swiftCode;
        this.balance = 0;
    }

    public void setAccountInfo(String name, int number, String iban, String swiftCode) {
        this.bankName = name;
        this.bankNumber = number;
        this.Iban = iban;
        this.swift = swiftCode;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public String getBankName() {
        return this.bankName;
    }

    public int getBankNumber() {
        return this.bankNumber;
    }

    public String getIban() {
        return this.Iban;
    }

    public String getSwift() {
        return this.swift;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBankName(String name) {
        this.bankName = name;
    }

    public void setBankNumber(int number) {
        this.bankNumber = number;
    }

    public void setIban(String iban) {
        this.Iban = iban;
    }

    public void setSwift(String swiftCode) {
        this.swift = swiftCode;
    }
}
