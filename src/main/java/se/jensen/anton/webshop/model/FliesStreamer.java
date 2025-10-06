package se.jensen.anton.webshop.model;

public class FliesStreamer extends Product {
    public FliesStreamer(String articleNumber, String title, String price, String description) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setPrice(price);
        setDescription(description);
        setCategory(category());
    }

    @Override
    public String category() {
        return "Streamer";
    }


}
