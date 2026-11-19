package main;

import java.util.Scanner;

/* 
Core class of our program that handles the menu setup and general flow, 
architecture has been adjusted from the original design to improve scalability/readability 
and prevent overlap in admin/user state causing issues.

The prompt of what to do, getting user input itself, and all logic handling input is now delegated to the Menu derived classes.
The MainMenu now acts as an overarching state machine just handling the transition of states.
*/

public class MainMenu {

    private final UserMenu userMenu;
    private final AdminMenu adminMenu;

    public MainMenu() {
        SharedMenuState state = new SharedMenuState(
                new Scanner(System.in),
                new Bank(),
                new BankAccount());
        this.adminMenu = new AdminMenu(state);
        this.userMenu = new UserMenu(state, adminMenu);
    }

    public void run() {
        Menu currentMenu = userMenu;
        while (true) {
            Menu.MenuAction action = currentMenu.runMenu();
            switch (action) {
                case EXIT_APP:
                    return;
                case ENTER_ADMIN:
                    currentMenu = adminMenu;
                    break;
                case EXIT_ADMIN:
                    currentMenu = userMenu;
                    break;
                case CONTINUE:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        MainMenu bankApp = new MainMenu();
        bankApp.run();
    }

}
