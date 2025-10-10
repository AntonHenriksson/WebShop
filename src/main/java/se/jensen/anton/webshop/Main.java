package se.jensen.anton.webshop;

import se.jensen.anton.webshop.controller.ConsoleInputProvider;
import se.jensen.anton.webshop.controller.ControllerRequest;
import se.jensen.anton.webshop.controller.InputProvider;
import se.jensen.anton.webshop.controller.MainMenuController;
import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.view.ViewMenuMain;

public class Main {
    public static void main(String[] args) {
        InputProvider inputProvider = new ConsoleInputProvider();
        MainMenuController menu = new MainMenuController(new ViewMenuMain(), new ModelMenu(), inputProvider);
        menu.mainMenu(ControllerRequest.dummy());


    }


}
