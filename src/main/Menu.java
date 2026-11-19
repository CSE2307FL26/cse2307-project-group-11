package main;

import java.util.Scanner;

public abstract class Menu {

    public enum MenuAction {
        CONTINUE,
        EXIT_APP,
        ENTER_ADMIN,
        EXIT_ADMIN
    }

    protected final Scanner keyboardInput;
    protected final MenuState state;
    protected final int maxSelection;
    protected final int exitSelection;

    protected Menu(MenuState state, int maxSelection, int exitSelection) {
        this.state = state;
        this.keyboardInput = state.getKeyboardInput();
        this.maxSelection = maxSelection;
        this.exitSelection = exitSelection;
    }

    public abstract void displayOptions();

    public abstract MenuAction processInput(int selection);

    public int getSelection() {
        int selection = -1;
        while (selection < 1 || selection > maxSelection) {
            System.out.print("Please make a selection: ");
            selection = keyboardInput.nextInt();
            keyboardInput.nextLine();
        }
        return selection;
    }

    public boolean exitSelected(int selection) {
        return selection == exitSelection;
    }

    public MenuAction runMenu() {
        displayOptions();
        int selection = getSelection();
        if (exitSelected(selection)) {
            return MenuAction.EXIT_APP;
        }
        return processInput(selection);
    }
}
