package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.model.ProductRepo;
import se.jensen.anton.webshop.view.ProductView;
import se.jensen.anton.webshop.view.ViewMainMenu;

public class MainMenuController extends MenuController {
    public MainMenuController(ViewMainMenu view, ModelMenu model, InputController input) {
        super(view, model, input);
    }


    public void mainMenu(ProductController productController) {
        while (getModel().isRunning()) {
            new ProductController(new ProductView(), new ProductRepo());
            getView().showMenu();
            switch (menuChoice()) {
                case 1 -> {
                    System.out.println("View ALL Products");
                    productController.listProducts();
                }
                case 2 -> System.out.println("Add NEW Product");
                //add new product
                case 3 -> System.out.println("Remove EXISTING Product");
                // exising
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
