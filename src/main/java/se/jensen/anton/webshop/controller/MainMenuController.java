package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.*;
import se.jensen.anton.webshop.view.ProductView;
import se.jensen.anton.webshop.view.ViewJOptionMenu;
import se.jensen.anton.webshop.view.ViewMainMenu;

public class MainMenuController extends MenuController {
    public MainMenuController(ViewMainMenu view, ModelMenu model, InputController input) {
        super(view, model, input);
    }


    public void mainMenu(ControllerRequest controllerRequest) {
        ProductFile productFile = new ProductFile();
        productFile.createFile();
        ProductController productController = new ProductController(new ProductView(),
                new ProductRepo());
        productController.importFile(productFile.makeNewOldList());

        while (getModel().isRunning()) {
            int choice = getMenuUserChoice();
            switch (choice) {
                case 1 -> {
                    productController.listProducts();
                }
                case 3 -> {
                    logicAddProduct(controllerRequest, productController);
                }
                case 4 -> {
                    viewSpecific(productController);
                }
                case 5 -> {
                    exitMenu(productFile, productController);
                }
            }
        }
    }

    private void exitMenu(ProductFile productFile,
                          ProductController productController) {
        System.out.println("Quit");
        productFile.writeToFile(productController.getProducts());
        getModel().quit();
    }

    private void removeProduct(ProductController productController) {
        System.out.println("Enter the articlenumber of the product you want to remove.");
        productController.removeProduct(getInput().getInput());
    }

    private void viewSpecific(ProductController productController) {
        System.out.println("Enter the articlenumber of the product you want to see.");
        productController.showSpecificProduct(getInput().getInput());
    }

    private int getMenuUserChoice() {
        if (getView() instanceof ViewJOptionMenu guiView) {
            return guiView.guiMenuChoice();
        } else {
            getView().showMenu();
            return menuChoice();
        }
    }

    private void logicAddProduct(ControllerRequest controllerRequest,
                                 ProductController productController) {
        int addChoice;
        if (getView() instanceof ViewJOptionMenu guiView) {
            addChoice = guiView.guiAddMenuChoice();
        } else {
            getView().showAddMenu();
            addChoice = menuChoice();
        }
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
            default -> {
                System.out.println("Invalid choice.");
            }
        }
    }

}
