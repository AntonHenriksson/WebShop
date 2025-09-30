package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.Menu;
import se.jensen.anton.webshop.model.Product;
import se.jensen.anton.webshop.model.WetFlies;
import se.jensen.anton.webshop.view.AddProduct;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        //  menu.mainMenu(scanner);
        Product montana = new WetFlies();
        AddProduct add = new AddProduct();
        //montana.setArticleNumber(add.addArticleNumber(scanner));
        //System.out.println(montana.getArticleNumber());

        System.out.println(montana.getTitle());

        scanner.close();

    }
}
