public class BankAccount {
    private String bankName;
    private int bankNumber;
    private int Iban;
    private int swift;
    
    public BankAccount(String name, int number, int iban, int swiftCode) {
        this.bankName = name;       // Set the bank name
        this.bankNumber = number;   // Set the account number
        this.Iban = iban;           // Set the IBAN
        this.swift = swiftCode;     // Set the SWIFT code
    }
    
    public void setAccountInfo(String name, int number, int iban, int swiftCode) {
        this.bankName = name;       // Update the bank name
        this.bankNumber = number;   // Update the account number
        this.Iban = iban;           // Update the IBAN
        this.swift = swiftCode;     // Update the SWIFT code
    }
  
    public boolean makePayment(double amount) {
        if (amount > 0) {
            return true;   
        }
        return false;
    }
  
    public boolean deposit(double amount) {
        if (amount > 0) {
            return true;   
        }
        return false;
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

