package main;

@FunctionalInterface
interface MenuOptionAction {
    Menu.MenuAction execute();
}
