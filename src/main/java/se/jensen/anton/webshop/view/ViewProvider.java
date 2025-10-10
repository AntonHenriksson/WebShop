package se.jensen.anton.webshop.view;

public interface ViewProvider {
    public String info(String message);

    public void error();

    public String prompt();

    default void setPrompt(String prompt) {
    }


}
