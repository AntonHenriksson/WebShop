package se.jensen.anton.webshop.view;

public class ArticleNumberView implements InputView {
    @Override
    public void info(String message) {
        System.out.println("You typed: ---" + message + "--- is that correct?");


    }

    @Override
    public String prompt() {
        return "Enter articlenumber for the Product, 5 digits";
    }
}
