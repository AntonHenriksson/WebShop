package se.jensen.anton.webshop.view;


import se.jensen.anton.webshop.controller.InputProvider;

public class ViewProviderScanner implements ViewProvider {
    private String prompt;
    private final InputProvider inputProvider;

    public ViewProviderScanner(String prompt, InputProvider inputProvider) {
        this.prompt = prompt;
        this.inputProvider = inputProvider;

    }

    @Override
    public void error() {
        this.prompt = prompt;
        System.out.println("Error. Please Follow: " + prompt);
    }

    @Override
    public String info(String message) {
        return inputProvider.getString("You typed: ---" + message + "--- is that correct? yes/no?");

    }

    @Override
    public String prompt() {
        return inputProvider.getString(prompt);
    }


}
