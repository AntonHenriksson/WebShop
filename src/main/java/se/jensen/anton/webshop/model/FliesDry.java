package se.jensen.anton.webshop.model;

import se.jensen.anton.webshop.controller.ControllerRequest;

import java.util.List;

public class FliesDry extends Product {


    public FliesDry(String articleNumber, String title, String price, String description) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setPrice(price);
        setDescription(description);
    }

    public FliesDry createDryFly(ControllerRequest controllerRequest) {
        List<String> input = controllerRequest.requestData(controllerRequest.createControllerRequests());
        FliesDry fliesDry = new FliesDry(input.get(0), input.get(1), input.get(2), input.get(3));
        return fliesDry;
    }


    @Override
    public String category() {
        return "Dry";
    }
}

