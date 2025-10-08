package se.jensen.anton.webshop.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductFile {

    private final String STORAGE_FILE = "src/main/java/se/jensen/anton/webshop/products.txt";

    public void createFile() {
        Path file = Path.of(STORAGE_FILE);
        try {
            Files.createFile(file);


        } catch (IOException e) {
            if (file.toFile().exists()) {
                System.out.println(file + " already exists");
            } else {
                e.printStackTrace();
            }
        }
    }

    public String SetObjectToString(Product product) {
        return product.getArticleNumber() + "!!!" + product.getTitle() + "!!!" + product.getPrice() + "!!!" + product.getDescription() + "!!!" + product.getCategory();
    }

    public Product SetStringToObject(String string) {
        String[] parts = string.split("!!!", 5);
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid string");
        }
        String artnumber = parts[0];
        String title = parts[1];
        String price = parts[2];
        String description = parts[3];
        String category = parts[4];
        switch (category) {
            case "Dry" -> {
                return new FliesDry(artnumber, title, price, description);
            }
            case "Nymph" -> {
                return new FliesNymph(artnumber, title, price, description);
            }
            case "Streamer" -> {
                return new FliesStreamer(artnumber, title, price, description);
            }
            default -> {
                return null;
            }

        }
    }


    public void writeToFile(List<Product> products) {

        String appendThis = "";
        for (Product product : products) {
            appendThis += SetObjectToString(product) + System.lineSeparator();
        }
        try {
            Files.writeString(Path.of(STORAGE_FILE), appendThis, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public List<Product> makeNewOldList() {
        ProductFile productFile = new ProductFile();
        List<Product> productList = new ArrayList<>();
        try {
            List<String> stringProducts = Files.readAllLines(Path.of(STORAGE_FILE));
            for (String stringProduct : stringProducts) {
                productList.add(productFile.SetStringToObject(stringProduct));

            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return productList;
    }


}



