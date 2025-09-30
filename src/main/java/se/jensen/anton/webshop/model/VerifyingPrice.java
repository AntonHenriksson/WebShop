package se.jensen.anton.webshop.model;

public class VerifyingPrice implements Verifying {

    @Override
    public boolean valid(String message) {
        try {
            double value = Double.parseDouble(message);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String format(String message) {
        double value = Double.parseDouble(message);
        return String.format("%.2f", value);
    }
}
