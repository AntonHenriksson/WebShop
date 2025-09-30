package se.jensen.anton.webshop.controller;


import se.jensen.anton.webshop.model.Verifying;
import se.jensen.anton.webshop.view.InputView;

import java.util.Scanner;


public class ScannerInput {
    private final Scanner scanner;

    public ScannerInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMessage(Verifying verifying, InputView view) {
        while (true) {
            System.out.println(view.prompt());
            String message = scanner.nextLine();
            if (!verifying.valid(message)) {
                continue;
            } else {
                view.info(message);
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    return verifying.format(message);
                }
            }

        }

    }
}
