package main;

public class AdminMenu extends Menu {
    private static final String ADMIN_PASSWORD = "adminadmin"; // TODO: perhaps add real security
    private static final String QUIT_STRING = "q";
    private static final int LOGIN_SUCCESS = 0;
    private static final int LOGIN_QUIT = 1;
    private static final int LOGIN_FAIL = 2;

    public AdminMenu(SharedMenuState state) {
        super(state, "You are in admin mode.");
        configureOptions();
    }

    @Override
    protected void configureOptions() {
        addOption("Charge fee", () -> {
            chargeFee();
            return MenuAction.CONTINUE;
        });
        addOption("Exit admin mode", () -> {
            exitAdminMode();
            return MenuAction.EXIT_ADMIN;
        });
        addOption("Exit the app", () -> MenuAction.EXIT_APP);
    }

    boolean adminLogin() {
        int loginStatus = loginPrompt();
        if (loginStatus == LOGIN_SUCCESS) {
            System.out.println("Admin login successful, entering admin mode");
            return true;
        } else {
            System.out.println("Admin login prompt exited");
            return false;
        }
    }

    private int loginPrompt() {
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

    private void exitAdminMode() {
        System.out.println("Exited admin mode. ");
    }

    private void chargeFee() {
        double feeAmount = -1;
        while (feeAmount < 0) {
            System.out.print("How much would you like to charge for a fee: ");
            feeAmount = keyboardInput.nextInt();
        }
        state.getUserAccount().chargeFee(feeAmount);
    }

}
