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
        Product montana = new FliesStreamer();
        montana.setCategory(montana.category());
        MenuController menu = new MenuController(new ViewMainMenu(), new ModelMenu(), new ScannerInput(scanner));
        montana.setDescription("Good for trout");
        montana.setTitle("montana");
        montana.setPrice("4.25");
        montana.setArticleNumber("11111");
        ProductController productController = new ProductController(new ProductView(), new ProductRepo());
        productController.addProduct(montana);
        productController.listProducts();
        productController.listSpecificProduct("11111");


        scanner.close();
    }
}
