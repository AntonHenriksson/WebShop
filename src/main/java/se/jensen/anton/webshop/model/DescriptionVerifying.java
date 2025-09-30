package se.jensen.anton.webshop.model;

public class DescriptionVerifying implements Verifying {
    @Override
    public boolean valid(String message) {
        return !message.isBlank();
    }

    @Override
    public String format(String message) {
        return message;
    }
}
