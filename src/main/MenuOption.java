package main;

public class MenuOption {

    private final String name;
    private final MenuOptionAction action;

    MenuOption(String name, MenuOptionAction action) {
        this.name = name;
        this.action = action;
    }

    String getName() {
        return name;
    }

    Menu.MenuAction execute() {
        return action.execute();
    }
}
