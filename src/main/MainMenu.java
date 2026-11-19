package main;

import java.util.Scanner;

public class MainMenu {

    private final UserMenu userMenu;
    private final AdminMenu adminMenu;

    public MainMenu() {
        MenuState state = new MenuState(
            new Scanner(System.in),
            new Bank(),
            new BankAccount()
        );
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
