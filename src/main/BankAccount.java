package main;

import java.util.ArrayList;

public class BankAccount {

    private double balance;
    private final ArrayList<Transaction> transactions;

    public BankAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.transactions.add(new Transaction("deposit",amount));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
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

    public ArrayList<Transaction> getTransactionHistory() {
        return transactions;
    }
}

