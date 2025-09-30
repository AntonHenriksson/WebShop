package se.jensen.anton.webshop.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    boolean running = true;

    public void quit() {
        running = false;
    }

    public void mainMenu(Scanner scanner) {
        int choice = 0;
        while (running) {
            System.out.println("""
                    --------------------------
                        Welcome to the menu
                    --------------------------
                    1  View ALL Products
                    2  Add NEW Product
                    3  Remove EXISTING Product
                    4  View DETAILS Of Product
                    5  ---------QUIT----------
                    --------------------------
                    """);
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("View ALL Products");
                        //viewALL
                        break;
                    case 2:
                        System.out.println("Add NEW Product");
                        //addPRODUCTS
                        break;
                    case 3:
                        System.out.println("Remove EXISTING Product");
                        //removePRODUCTS
                        break;
                    case 4:
                        System.out.println("View DETAILS Of Product");
                        //viewDETAILS
                        break;
                    case 5:
                        System.out.println("Quit");
                        quit();
                }

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
