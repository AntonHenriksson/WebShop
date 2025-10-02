package se.jensen.anton.webshop.view;

import se.jensen.anton.webshop.model.Product;

import java.util.List;

public class ProductView {


    public void showProducts(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("No products found");
        }
        for (Product product : products) {
            System.out.println(product);
        }

    }

    public void showPrompt(String prompt) {
        System.out.println(prompt);
    }
}
