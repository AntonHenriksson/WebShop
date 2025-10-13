package se.jensen.anton.webshop;

import se.jensen.anton.webshop.controller.ConsoleInputProvider;
import se.jensen.anton.webshop.controller.MainMenuController;
import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.view.ViewMenuConsole;
import se.jensen.anton.webshop.view.ViewMenuOption;

public class Main {
    public static void main(String[] args) {
        ModelMenu modelMenu = new ModelMenu();
        ViewMenuConsole viewMenuConsole = new ViewMenuConsole();
        ConsoleInputProvider consoleInputProvider = new ConsoleInputProvider();
        MainMenuController main = new MainMenuController(viewMenuConsole, modelMenu, consoleInputProvider);
        main.startMenu(consoleInputProvider, new ViewMenuOption());

    }


}
