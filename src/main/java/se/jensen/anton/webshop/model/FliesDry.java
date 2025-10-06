package se.jensen.anton.webshop.model;

public class FliesDry extends Product {


    public FliesDry(String articleNumber, String title, String price, String description) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setPrice(price);
        setDescription(description);
        setCategory(category());

    }


    @Override
    public String category() {
        return "Dry";
    }
}

