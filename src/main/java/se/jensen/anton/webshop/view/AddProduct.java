package se.jensen.anton.webshop.view;

import se.jensen.anton.webshop.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddProduct extends Product {

    public String addArticleNumber(Scanner scanner) {
        System.out.println("Enter articlenumber for the Product, 5 digits");

        while (true) {
            String articleNumber = scanner.nextLine();
            if (articleNumber.length() == 5) {
                try {
                    Integer.parseInt(articleNumber);
                    return articleNumber;
                } catch (NumberFormatException e) {
                    System.out.println("Enter valid articlenumber for the Product, 5 digits");
                }

            } else if (articleNumber.length() != 5) {
                System.out.println("Enter valid articlenumber for the Product, 5 digits");
            }
        }

    }

    public String addTitle(String title) {

        if (title.length() <= 15) {
            try {
                title = title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
                System.out.println("Is the title " + title + "?");
                System.out.println("Yes or no");
                if (title.equalsIgnoreCase("yes")) {
                    return title;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println();
            }


        }
    }

    public double addPrice(Scanner scanner) {
        System.out.println("Enter price for the Product, example: 4.99");
        while (true) {
            double price = 0;
            try {
                price = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Enter valid price for the Product, example: 4.99");
            }
            if (price > 0) {
                System.out.println("Is the price of " + price + " correct?");
                System.out.println("Yes or no");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    return price;
                }

            } else {
                System.out.println("Enter valid price for the Product, example: 4.99");
                price = scanner.nextDouble();
            }
        }
    }

    public String addDescription(Scanner scanner) {
        System.out.println("Enter description for the Product, example: This works well for trout");
        while (true) {
            String description = scanner.nextLine();
            if (description.isBlank()) {
                System.out.println("Enter description for the Product, example: This works well for trout");
                description = scanner.nextLine();
            } else System.out.println("Do you want to add this description?:\n" + description);
            System.out.println("Yes or no");
            if (scanner.nextLine().equalsIgnoreCase("Yes")) {
                return description;
            } else {
                System.out.println("Enter valid description for the Product, example: This works well for trout");
                description = scanner.nextLine();
            }
        }
    }

    //TODO
    @Override
    public String category() {
        System.out.println("What category are you adding to?");
        while (true) {

        }
    }
}