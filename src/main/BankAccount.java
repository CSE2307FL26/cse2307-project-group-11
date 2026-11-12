package main;

public class BankAccount {

    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Charged fees can go negative if needed
    public void chargeFee(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}
