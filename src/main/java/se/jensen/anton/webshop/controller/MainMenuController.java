package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.view.ViewMainMenu;

public class MainMenuController extends MenuController {
    public MainMenuController(ViewMainMenu view, ModelMenu model, InputController input) {
        super(view, model, input);
    }


    public void mainMenu() {
        while (getModel().isRunning()) {
            getView().showMenu();
            switch (menuChoice()) {
                case 1 -> System.out.println("View ALL Products");
                //viewALL
                case 2 -> System.out.println("Add NEW Product");
                //addPRODUCTS
                case 3 -> System.out.println("Remove EXISTING Product");
                //removePRODUCTS
                case 4 -> System.out.println("View DETAILS Of Product");
                //viewDETAILS
                case 5 -> {
                    System.out.println("Quit");
                    getModel().quit();
                }
            }
        }
    }

}
