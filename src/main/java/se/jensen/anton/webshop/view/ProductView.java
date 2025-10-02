package se.jensen.anton.webshop.view;

import se.jensen.anton.webshop.model.Product;

import java.util.List;

public class ProductView {


    public void showProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Theres no products to list");
        } else {
            System.out.println("------- Products listed below -------");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void showProduct(Product product) {
        System.out.println(product);
    }

    public void showPrompt(String prompt) {
        System.out.println(prompt);
    }
}
