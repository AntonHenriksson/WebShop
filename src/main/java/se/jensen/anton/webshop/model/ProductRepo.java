package se.jensen.anton.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private final List<Product> PRODUCTS = new ArrayList<>();


    public void add(Product product) {
        PRODUCTS.add(product);
    }

    public void remove(Product product) {
        PRODUCTS.remove(product);
    }

    public List<Product> getPRODUCTS() {
        return new ArrayList<>(PRODUCTS);
    }


    public Product getWithArticleNum(String articleNum) {
        for (Product product : PRODUCTS) {
            if (product.getArticleNumber().equals(articleNum)) {
                return product;
            }

        }
        return null;
    }

}

