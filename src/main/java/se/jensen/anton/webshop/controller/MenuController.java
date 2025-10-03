package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.view.ViewMenu;

public class MenuController {

    private final InputController input;
    private final ViewMenu view;
    private final ModelMenu model;

    public MenuController(ViewMenu view, ModelMenu model, InputController input) {
        this.input = input;
        this.view = view;
        this.model = model;
    }


    public int menuChoice() {
        int choice = 0;

        try {
            choice = Integer.parseInt(input.getInput());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, enter a number please");
        }
        return choice;
    }

    protected InputController getInput() {
        return input;
    }

    protected ViewMenu getView() {
        return view;
    }

    protected ModelMenu getModel() {
        return model;
    }
}
