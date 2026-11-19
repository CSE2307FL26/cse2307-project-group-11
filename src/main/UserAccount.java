package main;

import java.util.ArrayList;

public class UserAccount {
    private String accountName;
    private ArrayList<BankAccount> accounts;

    public UserAccount() {
        accountName = "Jane Doe";
        accounts = new ArrayList<>();
    }

    public void deleteAccount(int accountNumber) {
        if (accountNumber < 1 || accountNumber > accounts.size()) {
            throw new IndexOutOfBoundsException("Invalid Account Number");
        }
        accounts.remove(accountNumber - 1);
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public String getAccountName() {
        return accountName;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
}
