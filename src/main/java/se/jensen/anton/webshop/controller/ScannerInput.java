package se.jensen.anton.webshop.controller;


import java.util.Scanner;


public class ScannerInput implements InputController {

    private final Scanner scanner;

    public ScannerInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput() {

        return scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }


}
