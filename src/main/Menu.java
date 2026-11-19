package main;

import java.util.Scanner;
import java.util.ArrayList;

/*
This Menu abstract class outlines what is shared between MainMenu and AdminMenu. 
Each has shared state stored in the SharedMenuState type variable.
Each handles displaying options and processing input the same so that is shared in this class.

The differences between classes with this architecture now just come down to adding a method and an option to the "configureOptions()" method
that each subclass should implement and call in its constructor.
*/
public abstract class Menu {

    public enum MenuAction {
        CONTINUE,
        EXIT_APP,
        ENTER_ADMIN,
        EXIT_ADMIN
    }

    protected final String stateStartPrompt;
    protected final Scanner keyboardInput;
    protected final SharedMenuState state;
    protected final ArrayList<MenuOption> options = new ArrayList<>();

    protected Menu(SharedMenuState state, String stateStartPrompt) {
        this.state = state;
        this.stateStartPrompt = stateStartPrompt;
        this.keyboardInput = state.getKeyboardInput();
    }

    protected abstract void configureOptions(); // All should override this method

    private void displayOptions() {
        System.out.println(stateStartPrompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i).getName());
        }
    }

    public void addOption(String name, MenuOptionAction action) {
        options.add(new MenuOption(name, action));
    }

    private MenuAction processInput(int selection) {
        int optionIndex = selection - 1;
        if (optionIndex >= 0 && optionIndex < options.size()) {
            return options.get(optionIndex).execute();
        }
        return MenuAction.CONTINUE;
    }

    private int getSelection() {
        int selection = -1;
        while (selection < 1 || selection > options.size()) {
            System.out.print("Please make a selection: ");
            selection = keyboardInput.nextInt();
            keyboardInput.nextLine();
        }
        return selection;
    }

    public MenuAction runMenu() {
        displayOptions();
        int selection = getSelection();
        return processInput(selection);
    }
}
