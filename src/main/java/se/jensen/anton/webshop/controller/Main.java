package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.view.ViewInputPrice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ViewInputPrice view = new ViewInputPrice();

        ScannerInput input = new ScannerInput(scanner);


        scanner.close();
    }
}
