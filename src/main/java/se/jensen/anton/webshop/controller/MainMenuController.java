package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.*;
import se.jensen.anton.webshop.view.ProductView;
import se.jensen.anton.webshop.view.ViewMainMenu;

public class MainMenuController extends MenuController {
    public MainMenuController(ViewMainMenu view, ModelMenu model, InputController input) {
        super(view, model, input);
    }


    public void mainMenu(ControllerRequest controllerRequest) {
        ProductFile productFile = new ProductFile();
        productFile.createFile();
        ProductController productController = new ProductController(new ProductView(), new ProductRepo());
        productController.importFile(productFile.makeNewOldList());
        while (getModel().isRunning()) {
            getView().showMenu();
            switch (menuChoice()) {
                case 1 -> {
                    System.out.println("View ALL Products");
                    productController.listProducts();
                }
                case 2 -> {
                    getView().showAddMenu();
                    switch (menuChoice()) {
                        case 1 -> {
                            FliesDry dry = ProductFactory.createFliesDry(controllerRequest);
                            productController.addProduct(dry);
                        }
                        case 2 -> {
                            FliesNymph nymph = ProductFactory.createFliesNymph(controllerRequest);
                            productController.addProduct(nymph);
                        }
                        case 3 -> {
                            FliesStreamer streamer = ProductFactory.createFliesStreamer(controllerRequest);
                            productController.addProduct(streamer);
                        }
                        case 4 -> {
                            break;
                        }
                    }
                }

                case 3 -> {
                    System.out.println("Enter the articlenumber of the product you want to remove.");
                    productController.removeProduct(getInput().getInput());
                }
                case 4 -> {
                    System.out.println("Enter the articlenumber of the product you want to see.");
                    productController.showSpecificProduct(getInput().getInput());
                }
                case 5 -> {
                    System.out.println("Quit");
                    productFile.writeToFile(productController.getProducts());
                    getModel().quit();
                }
            }
        }
    }


}
