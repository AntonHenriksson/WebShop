package se.jensen.anton.webshop;

import se.jensen.anton.webshop.controller.ControllerRequest;
import se.jensen.anton.webshop.controller.MainMenuController;
import se.jensen.anton.webshop.controller.ScannerInput;
import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.view.ViewMainMenu;

public class Main {
    public static void main(String[] args) {
        ControllerRequest controllerRequest = new ControllerRequest(null, null, null);
        MainMenuController menuController = new MainMenuController(new ViewMainMenu(), new ModelMenu(), new ScannerInput());
        menuController.mainMenu(controllerRequest);


    }


}
