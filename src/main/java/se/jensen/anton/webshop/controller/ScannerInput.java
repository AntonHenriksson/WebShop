package se.jensen.anton.webshop.controller;


import se.jensen.anton.webshop.model.Verifying;
import se.jensen.anton.webshop.view.InputView;

import java.util.Scanner;


public class ScannerInput {
    private final InputView view;
    private final Scanner scanner = new Scanner(System.in);


    public ScannerInput(InputView view) {
        this.view = view;
    }


    public String getMessage(Verifying verifying) {
        while (true) {
            System.out.println(view.prompt());
            String message = scanner.nextLine();
            if (!verifying.valid(message)) {
                System.out.println(view.prompt());
            } else {
                view.info(message);
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    return verifying.format(message);
                }
            }

        }

    }
}
