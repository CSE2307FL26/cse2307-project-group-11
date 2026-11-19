package main;

import java.util.Scanner;

public class MenuState {

    private final Scanner keyboardInput;
    private final Bank bank;
    private final BankAccount userAccount;

    public MenuState(Scanner keyboardInput, Bank bank, BankAccount userAccount) {
        this.keyboardInput = keyboardInput;
        this.bank = bank;
        this.userAccount = userAccount;
    }

    public Scanner getKeyboardInput() {
        return keyboardInput;
    }

    public Bank getBank() {
        return bank;
    }

    public BankAccount getUserAccount() {
        return userAccount;
    }
}
