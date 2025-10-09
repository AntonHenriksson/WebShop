package se.jensen.anton.webshop;

import se.jensen.anton.webshop.controller.ControllerRequest;
import se.jensen.anton.webshop.controller.GuiInputProvider;
import se.jensen.anton.webshop.controller.InputProvider;
import se.jensen.anton.webshop.controller.MainMenuController;
import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.view.ViewMainMenu;

public class Main {
    public static void main(String[] args) {
        InputProvider inputProvider = new GuiInputProvider();
        MainMenuController menu = new MainMenuController(new ViewMainMenu(), new ModelMenu(), inputProvider);
        menu.mainMenu(new ControllerRequest(null, null, null));


    }


}
