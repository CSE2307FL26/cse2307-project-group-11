package main;

import java.util.Scanner;

public abstract class Menu {

    protected final Scanner keyboardInput;
    protected final int maxSelection;
    protected final int exitSelection;

    protected Menu(Scanner keyboardInput, int maxSelection, int exitSelection) {
        this.keyboardInput = keyboardInput;
        this.maxSelection = maxSelection;
        this.exitSelection = exitSelection;
    }

    public abstract void displayOptions();

    public abstract void processInput(int selection);

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

    public boolean runMenu() {
        displayOptions();
        int selection = getSelection();
        if (exitSelected(selection)) {
            return true;
        }
        processInput(selection);
        return false;
    }
}
