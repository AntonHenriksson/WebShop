package se.jensen.anton.webshop.model;

import se.jensen.anton.webshop.view.ViewMenu;

import java.util.Scanner;

public class Menu {
    boolean running = true;
    private Scanner scanner = new Scanner(System.in);

    public void quit() {
        running = false;
    }


    public int menuChoice() {
        int choice = 0;

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, enter a number please");
        }
        return choice;
    }

    public void mainMenu() {

        while (running) {
            ViewMenu viewMenu = new ViewMenu();
            viewMenu.showMenu();
            switch (menuChoice()) {
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


        }

    }
}
