package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.TitleVerifying;
import se.jensen.anton.webshop.view.TitleView;

public class Main {
    public static void main(String[] args) {
        TitleView view = new TitleView();
        ScannerInput input = new ScannerInput(view);

        input.getMessage(new TitleVerifying());


    }
}
