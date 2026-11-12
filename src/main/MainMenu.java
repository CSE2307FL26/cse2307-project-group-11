package main;

import java.util.Scanner;

public class MainMenu {

    private static final int EXIT_SELECTION_USER = 3;
    private static final int MAX_SELECTION_USER = 3;
    private static final int EXIT_SELECTION_ADMIN = 3;
    private static final int MAX_SELECTION_ADMIN = 3;

    // Admin related constants, may potentially later be used for user logins
    private static final String ADMIN_PASSWORD = "adminadmin";
    private static final String QUIT_STRING = "q";
    private static final int LOGIN_SUCCESS = 0;
    private static final int LOGIN_QUIT = 1;
    private static final int LOGIN_FAIL = 2;

    private BankAccount userAccount;
    private Scanner keyboardInput;

    private boolean isAdmin;

    public MainMenu() {
        this.userAccount = new BankAccount();
        this.keyboardInput = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("Welcome to the 237 Bank App!");

        System.out.println("1. Make a deposit");
        System.out.println("2. Login as administrator");
        System.out.println("3. Exit the app");

    }

    public void displayAdminOptions() {
        System.out.println("You are in admin mode.");

        System.out.println("1. Charge fee");
        System.out.println("2. Exit admin mode");
        System.out.println("3. Exit admin mode");

    }

    public void adminLogin() {
        int loginStatus = loginPrompt();
        if (loginStatus == LOGIN_SUCCESS) {
            System.out.println("Admin login successful, entering admin mode");
            isAdmin = true;
        } else {
            System.out.println("Admin login prompt exited");
        }
    }

    public int loginPrompt() {
        System.out.println("Enter admin password, or type \"" + QUIT_STRING + "\" to quit: ");
        String enteredPassword = "";
        while (!enteredPassword.equals(ADMIN_PASSWORD) && !enteredPassword.equals(QUIT_STRING)) {
            enteredPassword = keyboardInput.nextLine();
            if (enteredPassword.equals(ADMIN_PASSWORD)) {
                return LOGIN_SUCCESS;
            } else if (enteredPassword.equals(QUIT_STRING)) {
                return LOGIN_QUIT;
            } else {
                System.out.println("Incorrect admin password. Try again or type \"" + QUIT_STRING + "\" to quit: ");
            }
        }
        return LOGIN_FAIL;

    }

    public int getUserSelection(int max) {
        int selection = -1;
        while (selection < 1 || selection > max) {
            System.out.print("Please make a selection: ");
            selection = keyboardInput.nextInt();
        }
        return selection;
    }

    public void processInput(int selection) {
        switch (selection) {
            case 1:
                performDeposit();
                break;
            case 2:
                loginPrompt();
                break;
        }
    }

    public void performDeposit() {
        double depositAmount = -1;
        while (depositAmount < 0) {
            System.out.print("How much would you like to deposit: ");
            depositAmount = keyboardInput.nextInt();
        }
        userAccount.deposit(depositAmount);
    }

    public void run() {
        int selection = -1;
        while (selection != EXIT_SELECTION_USER) {
            displayOptions();
            selection = getUserSelection(MAX_SELECTION_USER);
            processInput(selection);
        }
    }

    public static void main(String[] args) {
        MainMenu bankApp = new MainMenu();
        bankApp.run();
    }

}
