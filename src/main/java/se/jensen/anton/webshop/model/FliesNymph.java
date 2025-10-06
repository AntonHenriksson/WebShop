package se.jensen.anton.webshop.model;

public class FliesNymph extends Product {

    public FliesNymph(String articleNumber, String title, String price, String description) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setPrice(price);
        setDescription(description);
        setCategory(category());

    }


    @Override
    public String category() {
        return "Nymph";
    }
}
