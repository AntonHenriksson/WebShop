package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.*;
import se.jensen.anton.webshop.view.*;

public class MainMenuController extends MenuController {
    public MainMenuController(ViewMenu view, ModelMenu model, InputProvider inputProvider) {
        super(view, model, inputProvider);
    }

    public void startMenu(InputProvider inputProvider, ViewMenuOption viewMenu) {
        viewMenu.showMenu();
        ControllerRequest controllerRequest;
        ViewProduct viewProduct;
        String choice = getInput().getString("Choose: ");
        if (choice.equals("2")) {
            controllerRequest = new ControllerRequest
                    (null, null, new GuiInputProvider());
            viewProduct = new ViewProductGui();
        } else {
            controllerRequest = new ControllerRequest
                    (null, null, new ConsoleInputProvider());
            viewProduct = new ViewProductConsole();
        }
        mainMenu(controllerRequest, viewProduct);
    }


    public void mainMenu(ControllerRequest controllerRequest, ViewProduct viewProduct) {
        ProductFile productFile = new ProductFile();
        productFile.createFile();
        ProductController productController = new ProductController(viewProduct,
                new ProductRepo());
        productController.importFile(productFile.makeNewOldList());


        while (getModel().isRunning()) {
            int choice = getMenuUserChoice();
            switch (choice) {
                case 1 -> {
                    productController.listProducts();
                }
                case 2 -> {
                    logicAddProduct(controllerRequest, productController);
                }
                case 3 -> {
                    removeProduct(productController);
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
        String input = getInput().getString("Enter the articlenumber of the product you want to remove.");
        productController.removeProduct(input);
    }

    private void viewSpecific(ProductController productController) {
        productController.showSpecificProduct(getInput().getString("Enter the articlenumber of the product you want to see."));
    }

    private int getMenuUserChoice() {
        if (getView() instanceof ViewMenuJOptionMenu guiView) {
            return guiView.guiMenuChoice();
        } else {
            getView().showMenu();
            return menuChoice();
        }
    }

    private void logicAddProduct(ControllerRequest controllerRequest,
                                 ProductController productController) {
        int addChoice;
        if (getView() instanceof ViewMenuJOptionMenu guiView) {
            addChoice = guiView.guiAddMenuChoice();
        } else {
            getView().showAddMenu();
            addChoice = menuChoice();
        }
        switch (addChoice) {
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