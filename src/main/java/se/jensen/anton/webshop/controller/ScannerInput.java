package se.jensen.anton.webshop.controller;


import java.util.Scanner;


public class ScannerInput implements InputController {

    private final Scanner scanner = new Scanner(System.in);

    public ScannerInput() {

    }

    @Override
    public String getInput() {

        return scanner.nextLine();
    }


}
