package se.jensen.anton.webshop.model;

public class ArticleNumberVerifying implements Verifying {
    @Override
    public boolean valid(String message) {
        if (message.length() == 5) {
            try {
                int value = Integer.parseInt(message);
                return true;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    @Override
    public String format(String message) {
        return message;
    }
}
