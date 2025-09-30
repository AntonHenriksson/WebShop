package se.jensen.anton.webshop.view;

import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);

    public String promptTitle() {
        System.out.println("Enter title for the Product, Maximum 15 letters");
        return scanner.nextLine();
    }

    public boolean confirmTitle(String title) {
        System.out.println("Is this the correct title? Yes/no:  " + title);
        String validation = scanner.nextLine().trim();
        return validation.equalsIgnoreCase("yes");

    }


}
