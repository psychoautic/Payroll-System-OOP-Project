public class BankAccount {
    private String bankName;
    private int bankNumber;
    private int Iban;
    private int swift;
    private double balance;
    
    public BankAccount(String name, int number, int iban, int swiftCode) {
        this.bankName = name;       // Set the bank name
        this.bankNumber = number;   // Set the account number
        this.Iban = iban;           // Set the IBAN
        this.swift = swiftCode;     // Set the SWIFT code
        this.balance = 0.0;         // Initialize balance to zero
    }
    
    public void setAccountInfo(String name, int number, int iban, int swiftCode) {
        this.bankName = name;       // Update the bank name
        this.bankNumber = number;   // Update the account number
        this.Iban = iban;           // Update the IBAN
        this.swift = swiftCode;     // Update the SWIFT code
    }
  
    public boolean makePayment(double amount) {
        // Check if amount is valid and sufficient balance exists
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount; // Deduct the payment amount from balance
            return true;            // Return success
        }
        return false;               // Return failure
    }
  
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount; // Add the amount to balance
            return true;            // Return success
        }
        return false;               // Return failure
    }
    
    // Getters
    public String getBankName() {
        return this.bankName;
    }
   
    public int getBankNumber() {
        return this.bankNumber;
    }
   
    public int getIban() {
        return this.Iban;
    }
    
    public int getSwift() {
        return this.swift;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    // Setters
    public void setBankName(String name) {
        this.bankName = name;
    }
    
    public void setBankNumber(int number) {
        this.bankNumber = number;
    }
    
    public void setIban(int iban) {
        this.Iban = iban;
    }
    
    public void setSwift(int swiftCode) {
        this.swift = swiftCode;
    }
}
