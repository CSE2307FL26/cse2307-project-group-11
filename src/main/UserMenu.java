package main;

import java.util.ArrayList;

public class UserMenu extends Menu {

    public static final int EXIT_SELECTION = 7;
    public static final int MAX_SELECTION = 7;

    private final AdminMenu adminMenu;

    public UserMenu(MenuState state, AdminMenu adminMenu) {
        super(state, MAX_SELECTION, EXIT_SELECTION);
        this.adminMenu = adminMenu;
    }

    public void displayOptions() {
        System.out.println("Welcome to the 237 Bank App!");

        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdrawal");
        System.out.println("3. Get Balance");
        System.out.println("4. Create an additional account");
        System.out.println("5. Login as administrator");
        System.out.println("6. Display transaction history");
        System.out.println("7. Exit the app");
    }

    public MenuAction processInput(int selection) {
        switch (selection) {
            case 1:
                performDeposit();
                break;
            case 2:
                performWithdraw();
                break;
            case 3:
                retrieveBalance();
                break;
            case 4:
                if (adminMenu.adminLogin()) {
                    return MenuAction.ENTER_ADMIN;
                }
                break;
            case 5:
                performCreateAccount();
                break;
            case 6:
                printTransactionHistory();
                break;
        }
        return MenuAction.CONTINUE;
    }

    public void retrieveBalance() {
        System.out.println("You have: $" + state.getUserAccount().getBalance() + " in your account.");
    }

    public void performDeposit() {
        double depositAmount = -1;
        while (depositAmount < 0) {
            System.out.print("How much would you like to deposit: ");
            depositAmount = keyboardInput.nextInt();
        }
        state.getUserAccount().deposit(depositAmount);
    }

    public void performWithdraw() {
        double withdrawAmount = -1;
        while (withdrawAmount <= 0) {
            System.out.print("How much would you like to withdraw: ");
            withdrawAmount = keyboardInput.nextDouble();
        }

        try {
            state.getUserAccount().withdraw(withdrawAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void performCreateAccount() {
        state.getBank().createAccount();

        System.out.println("New account created successfully!");
        System.out.println("Total accounts: " + state.getBank().getAccountCount());
    }

    public void printTransactionHistory() {
        ArrayList<Transaction> transactions = state.getUserAccount().getTransactionHistory();
        System.out.println("---Transaction History---");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
