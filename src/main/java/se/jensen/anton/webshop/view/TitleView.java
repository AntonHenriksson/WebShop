package se.jensen.anton.webshop.view;

public class TitleView implements InputView {
    @Override
    public void info(String message) {
        System.out.println("You typed: ---" + message + "--- is that correct?");

    }

    @Override
    public String prompt() {
        return "Enter a title with maximum of 15 characters";
    }
}
