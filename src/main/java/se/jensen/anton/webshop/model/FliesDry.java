package se.jensen.anton.webshop.model;

import se.jensen.anton.webshop.controller.ControllerRequest;
import se.jensen.anton.webshop.controller.InputFactory;
import se.jensen.anton.webshop.controller.ScannerInput;
import se.jensen.anton.webshop.view.ViewInputDescription;

public class FliesDry extends Product {


    public FliesDry(String articleNumber, String title, String price, String description) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setPrice(price);
        setDescription(description);
    }

    private FliesDry createDry() {
        ControllerRequest descController = InputFactory.scannerController(new VerifyingDescription(), new ViewInputDescription(), new ScannerInput(scanner));
        String art;
        String title = setTitle(controllerRequest.requestData());
        String price = setPrice(controllerRequest.requestData());
        String desc = descController.requestData();
        return new FliesDry(art, title, price, desc);
    }

    @Override
    public String category() {
        return "Dry";
    }
}

