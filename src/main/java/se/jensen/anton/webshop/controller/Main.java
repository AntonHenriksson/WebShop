package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.view.PriceView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriceView view = new PriceView();

        ScannerInput input = new ScannerInput(scanner);


        scanner.close();
    }
}
