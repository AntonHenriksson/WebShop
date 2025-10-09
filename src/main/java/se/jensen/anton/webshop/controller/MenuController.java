package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.view.ViewMenu;

public class MenuController {

    private final InputProvider input;
    private final ViewMenu view;
    private final ModelMenu model;

    public MenuController(ViewMenu view, ModelMenu model, InputProvider input) {
        this.input = input;
        this.view = view;
        this.model = model;
    }


    public int menuChoice() {
        try {
            return Integer.parseInt(input.getString("Enter your choice"));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, enter a number please");
        }
        return 0;
    }

    protected InputProvider getInput() {
        return input;
    }

    protected ViewMenu getView() {
        return view;
    }

    protected ModelMenu getModel() {
        return model;
    }
}
