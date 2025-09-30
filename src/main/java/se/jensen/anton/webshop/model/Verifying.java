package se.jensen.anton.webshop.model;

public interface Verifying {
    public boolean valid(String message);

    public String format(String message);
}
