package se.jensen.anton.webshop.controller;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {
    private final Scanner scanner;

    public ConsoleInputProvider() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
