package se.jensen.anton.webshop.view;

public class ViewInputDescription implements ViewInput {
    @Override
    public void info(String message) {
        System.out.println("You typed: ---" + message + "--- is that correct?");

    }

    @Override
    public String prompt() {
        return "Enter description for the Product, example: This works well for trout";
    }
}
