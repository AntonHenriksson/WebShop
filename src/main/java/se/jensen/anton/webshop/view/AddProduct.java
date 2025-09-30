package se.jensen.anton.webshop.view;

import se.jensen.anton.webshop.model.Product;

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

    public String addTitle(Scanner scanner) {
        System.out.println("Enter title for the Product, Maximum 15 letters");
        while (true) {
            String title = scanner.nextLine();
            if (title.length() <= 15) {
                try {
                    title = title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
                    return title;
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Enter valid title for the Product, Maximum 15 letters");
                }
            } else {
                System.out.println("Enter valid title for the Product, Maximum 15 letters");
            }
        }
    }

    @Override
    public String category() {
        return "";
    }
}