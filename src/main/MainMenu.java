package main;

import java.util.Scanner;

public class MainMenu {

    private final UserMenu userMenu;
    private final AdminMenu adminMenu;

    public MainMenu() {
        Scanner keyboardInput = new Scanner(System.in);
        Bank bank = new Bank();
        BankAccount userAccount = new BankAccount();
        this.adminMenu = new AdminMenu(userAccount, keyboardInput);
        this.userMenu = new UserMenu(bank, userAccount, keyboardInput, adminMenu);
    }

    public void run() {
        Menu currentMenu = userMenu;
        while (true) {
            if (currentMenu.runMenu()) {
                break;
            }

            if (currentMenu == userMenu && adminMenu.isAdmin()) {
                currentMenu = adminMenu;
            } else if (currentMenu == adminMenu && !adminMenu.isAdmin()) {
                currentMenu = userMenu;
            }
        }
    }

    public static void main(String[] args) {
        MainMenu bankApp = new MainMenu();
        bankApp.run();
    }

}
