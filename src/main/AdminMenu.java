package main;

import java.util.Scanner;

public class AdminMenu extends Menu {

    public static final int EXIT_ADMIN_SELECTION = 2;
    public static final int EXIT_APP_SELECTION = 3;
    public static final int MAX_SELECTION = 3;

    private static final String ADMIN_PASSWORD = "adminadmin";
    private static final String QUIT_STRING = "q";
    private static final int LOGIN_SUCCESS = 0;
    private static final int LOGIN_QUIT = 1;
    private static final int LOGIN_FAIL = 2;

    private final BankAccount userAccount;
    private boolean isAdmin;

    public AdminMenu(BankAccount userAccount, Scanner keyboardInput) {
        super(keyboardInput, MAX_SELECTION, EXIT_APP_SELECTION);
        this.userAccount = userAccount;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void displayOptions() {
        System.out.println("You are in admin mode.");

        System.out.println("1. Charge fee");
        System.out.println("2. Exit admin mode");
        System.out.println("3. Exit the app");
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

    public void exitAdminMode() {
        System.out.println("Exited admin mode. ");
        isAdmin = false;
    }

    public void processInput(int selection) {
        switch (selection) {
            case 1:
                chargeFee();
                break;
            case 2:
                exitAdminMode();
                break;
        }
    }

    public void chargeFee() {
        double feeAmount = -1;
        while (feeAmount < 0) {
            System.out.print("How much would you like to charge for a fee: ");
            feeAmount = keyboardInput.nextInt();
        }
        userAccount.chargeFee(feeAmount);
    }

}
