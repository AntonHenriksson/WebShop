package se.jensen.anton.webshop;

import se.jensen.anton.webshop.controller.ScannerInput;
import se.jensen.anton.webshop.model.FliesStreamer;
import se.jensen.anton.webshop.model.Product;
import se.jensen.anton.webshop.model.VerifyingArticleNumber;
import se.jensen.anton.webshop.view.ViewInputArticleNumber;
import se.jensen.anton.webshop.view.ViewInputPrice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ViewInputPrice view = new ViewInputPrice();

        ScannerInput input = new ScannerInput(scanner);
        Product montana = new FliesStreamer();
        montana.setArticleNumber(input.getMessage(new VerifyingArticleNumber(), new ViewInputArticleNumber()));
        System.out.println(montana);
        scanner.close();
    }
}
