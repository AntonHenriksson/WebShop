package se.jensen.anton.webshop.view;

public interface ViewMenu {
    default void showMenu() {
    }

    ;

    default void showAddMenu() {
    }

    ;

    default int guiMenuChoice() {
        return -1;
    }

    default int guiAddMenuChoice() {
        return -1;
    }
}
