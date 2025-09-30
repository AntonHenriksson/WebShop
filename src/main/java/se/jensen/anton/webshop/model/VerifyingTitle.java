package se.jensen.anton.webshop.model;

public class VerifyingTitle implements Verifying {
    @Override
    public boolean valid(String message) {
        return !message.isBlank() && message.length() <= 15;
    }

    @Override
    public String format(String message) {
        return message.substring(0, 1).toUpperCase() + message.substring(1).toLowerCase();
    }


}
