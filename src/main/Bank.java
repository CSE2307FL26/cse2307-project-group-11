package main;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<BankAccount>();
        accounts.add(new BankAccount());
    }

    public BankAccount createAccount() {
        BankAccount newAccount = new BankAccount();
        accounts.add(newAccount);
        return newAccount;
    }

    public int getAccountCount() {
        return accounts.size();
    }

    public BankAccount getAccount(int index) {
        return accounts.get(index);
    }
}
