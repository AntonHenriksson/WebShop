package se.jensen.anton.webshop.view;

public class ViewInputPrice implements ViewInput {
    @Override
    public void info(String message) {
        System.out.println("You typed: ---" + message + "--- is that correct?");

    }

    @Override
    public String prompt() {
        return "Type the price using following example, 4.99";
    }
}
