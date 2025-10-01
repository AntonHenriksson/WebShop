package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.VerifyingArticleNumber;
import se.jensen.anton.webshop.view.ViewInputArticleNumber;

import java.util.Scanner;

public class InputFactory {
    private final Scanner scanner;

    public InputFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public static ControllerArticleNumber createScannerController(Scanner scanner) {
        VerifyingArticleNumber verifier = new VerifyingArticleNumber();
        ViewInputArticleNumber view = new ViewInputArticleNumber();
        InputController input = new ScannerInput(scanner);
        return new ControllerArticleNumber(verifier, view, input);


    }


}
