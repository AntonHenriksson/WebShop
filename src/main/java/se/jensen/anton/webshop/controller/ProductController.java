package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.Product;
import se.jensen.anton.webshop.model.ProductRepo;
import se.jensen.anton.webshop.view.ProductView;

public class ProductController {
    private ProductView view;
    private ProductRepo repo;

    public ProductController(ProductView view, ProductRepo repo) {
        this.view = view;
        this.repo = repo;
    }


    public void listProducts() {
        view.showProducts(repo.getProducts());
    }

    public void listSpecificProduct(String Articlenum) {
        view.showProduct(repo.getWithArticleNum(Articlenum));
    }

    public Product getSpecificProduct(String Articlenum) {
        return repo.getWithArticleNum(Articlenum);
    }

    public void addProduct(Product product) {
        repo.add(product);
        view.showPrompt("Product added" + product.getTitle());
    }

    public void removeProduct(String Articlenum) {
        repo.remove(getSpecificProduct(Articlenum));
    }
}




