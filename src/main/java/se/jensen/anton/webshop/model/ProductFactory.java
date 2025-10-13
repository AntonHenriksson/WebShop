package se.jensen.anton.webshop.model;

import se.jensen.anton.webshop.controller.ControllerRequest;

import java.util.List;

public class ProductFactory {
    public static FliesDry createFliesDry(ControllerRequest controllerRequest) {
        List<String> input = controllerRequest.requestData(controllerRequest.getRequestForCurrentMode());
        FliesDry fliesDry = new FliesDry(input.get(0), input.get(1), input.get(2), input.get(3));
        return fliesDry;
    }

    public static FliesNymph createFliesNymph(ControllerRequest controllerRequest) {
        List<String> input = controllerRequest.requestData(controllerRequest.getRequestForCurrentMode());
        FliesNymph FliesNymph = new FliesNymph(input.get(0), input.get(1), input.get(2), input.get(3));
        return FliesNymph;
    }

    public static FliesStreamer createFliesStreamer(ControllerRequest controllerRequest) {
        List<String> input = controllerRequest.requestData(controllerRequest.getRequestForCurrentMode());
        FliesStreamer fliesStreamer = new FliesStreamer(input.get(0), input.get(1), input.get(2), input.get(3));
        return fliesStreamer;
    }
}
