package se.jensen.anton.webshop.view;


public class ViewProviderScanner implements ViewProvider {
    private String prompt;

    public ViewProviderScanner(String prompt) {
        this.prompt = prompt;

    }

    @Override
    public void error() {
        this.prompt = prompt;
        System.out.println("Error. Please Follow: " + prompt);
    }

    @Override
    public String info(String message) {
        return "You typed: ---" + message + "--- is that correct?";

    }

    @Override
    public String prompt() {
        return prompt;
    }

    @Override
    public void setPrompt(String prompt) {

    }
}
