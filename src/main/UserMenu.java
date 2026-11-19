package main;

import java.util.ArrayList;

public class UserMenu extends Menu {
    private final AdminMenu adminMenu;

    public UserMenu(SharedMenuState state, AdminMenu adminMenu) {
        super(state, "Welcome to the 237 Bank App!");
        this.adminMenu = adminMenu;
        configureOptions();
    }

    @Override
    protected void configureOptions() {
        addOption("Make a deposit", () -> {
            performDeposit();
            return MenuAction.CONTINUE;
        });
        addOption("Make a withdrawal", () -> {
            performWithdraw();
            return MenuAction.CONTINUE;
        });
        addOption("Get Balance", () -> {
            retrieveBalance();
            return MenuAction.CONTINUE;
        });
        addOption("Create an additional account", () -> {
            performCreateAccount();
            return MenuAction.CONTINUE;
        });
        addOption("Login as administrator", () -> adminMenu.adminLogin()
                ? MenuAction.ENTER_ADMIN
                : MenuAction.CONTINUE);
        addOption("Display transaction history", () -> {
            printTransactionHistory();
            return MenuAction.CONTINUE;
        });
        addOption("Exit the app", () -> MenuAction.EXIT_APP);
    }

    private void retrieveBalance() {
        System.out.println("You have: $" + state.getUserAccount().getBalance() + " in your account.");
    }

    private void performDeposit() {
        double depositAmount = -1;
        while (depositAmount < 0) {
            System.out.print("How much would you like to deposit: ");
            depositAmount = keyboardInput.nextInt();
        }
        state.getUserAccount().deposit(depositAmount);
    }

    private void performWithdraw() {
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

    private void performCreateAccount() {
        state.getBank().createAccount();

        System.out.println("New account created successfully!");
        System.out.println("Total accounts: " + state.getBank().getAccountCount());
    }

    private void printTransactionHistory() {
        ArrayList<Transaction> transactions = state.getUserAccount().getTransactionHistory();
        System.out.println("---Transaction History---");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
