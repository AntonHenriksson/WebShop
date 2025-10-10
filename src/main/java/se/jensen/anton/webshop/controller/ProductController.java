package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.Product;
import se.jensen.anton.webshop.model.ProductRepo;
import se.jensen.anton.webshop.model.VerifyingArticleNumber;
import se.jensen.anton.webshop.view.ViewProduct;

import java.util.List;

public class ProductController {
    private ViewProduct view;
    private ProductRepo repo;


    public ProductController(ViewProduct view, ProductRepo repo) {
        this.view = view;
        this.repo = repo;
    }


    public void listProducts() {
        view.showProducts(repo.getPRODUCTS());
    }

    public void showSpecificProduct(String Articlenum) {
        view.showProduct(repo.getWithArticleNum(Articlenum));
    }

    public Product getSpecificProduct(String Articlenum) {
        return repo.getWithArticleNum(Articlenum);
    }

    public void addProduct(Product product) {
        if (!checkIfExist(product.getArticleNumber(), repo.getPRODUCTS())) {
            repo.add(product);
            view.showPrompt("Product added" + product.getTitle());
        } else {
            System.out.println("ArticleNumber already exist");
            System.out.println(getSpecificProduct(product.getArticleNumber()));
        }
    }

    private boolean checkIfExist(String message, List<Product> products) {
        for (Product product : products) {
            if (product.getArticleNumber().equals(message)) {
                return true;
            }

        }
        return false;

    }

    public void importFile(List<Product> products) {
        try {
            for (Product product : products)
                if (new VerifyingArticleNumber().valid(product.getArticleNumber()))
                    repo.add(product);
        } catch (IllegalArgumentException e) {
            System.out.println("Error importing product");
        }

    }

    public void removeProduct(String Articlenum) {
        view.showPrompt("Product removed" + Articlenum);
        repo.remove(getSpecificProduct(Articlenum));
    }

    public List<Product> getProducts() {
        return repo.getPRODUCTS();
    }


}




