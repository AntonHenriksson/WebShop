package se.jensen.anton.webshop.view;

import se.jensen.anton.webshop.model.Product;

import java.util.List;

public interface ViewProduct {

    public void showProducts(List<Product> products);

    public void showProduct(Product product);

    public void showPrompt(String prompt);
}
