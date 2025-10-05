package se.jensen.anton.webshop;

import se.jensen.anton.webshop.controller.*;
import se.jensen.anton.webshop.model.*;
import se.jensen.anton.webshop.view.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControllerRequest descController = InputFactory.scannerController(new VerifyingDescription(), new ViewInputDescription(), new ScannerInput(scanner));
        ControllerRequest artController = InputFactory.scannerController(new VerifyingArticleNumber(), new ViewInputArticleNumber(), new ScannerInput(scanner));
        ControllerRequest titleController = InputFactory.scannerController(new VerifyingTitle(), new ViewInputTitle(), new ScannerInput(scanner));
        ControllerRequest priceController = InputFactory.scannerController(new VerifyingPrice(), new ViewInputPrice(), new ScannerInput(scanner));
        MainMenuController mainController = new MainMenuController(new ViewMainMenu(), new ModelMenu(), new ScannerInput(scanner));
        mainController.mainMenu(new ProductController(new ProductView(), new ProductRepo()));

        scanner.close();
    }
}
