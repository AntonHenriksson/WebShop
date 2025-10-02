package se.jensen.anton.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private final List<Product> products = new ArrayList<>();


    public void add(Product product) {
        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }


    public Product getWithArticleNum(String articleNum) {
        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNum)) {
                return product;
            }

        }
        return null;
    }

}

