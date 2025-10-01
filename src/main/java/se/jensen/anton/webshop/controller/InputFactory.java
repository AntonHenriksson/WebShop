package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.Verifying;
import se.jensen.anton.webshop.view.ViewInput;

import java.util.Scanner;

public class InputFactory {
    private final Scanner scanner;

    public InputFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public static ControllerRequest scannerController(Verifying verifier, ViewInput view, InputController input) {

        return new ControllerRequest(verifier, view, input);


    }


}
