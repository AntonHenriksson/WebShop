package se.jensen.anton.webshop.model;

public class VerifyingArticleNumber implements Verifying {
    @Override
    public boolean valid(String message) {
        if (message.length() != 5) {
            return false;
        }
        {
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
