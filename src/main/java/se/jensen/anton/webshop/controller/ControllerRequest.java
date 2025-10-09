package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.*;
import se.jensen.anton.webshop.view.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerRequest {
    private final Verifying verifier;
    private final ViewInput view;
    private final InputProvider input;


    public ControllerRequest(Verifying verifier,
                             ViewInput view,
                             InputProvider input) {
        this.verifier = verifier;
        this.view = view;
        this.input = input;
    }


    public List<String> requestData(List<ControllerRequest> controllerRequests) {
        List<String> results = new ArrayList();
        for (ControllerRequest controllerRequest : controllerRequests) {
            while (true) {
                String message = controllerRequest.input.getString(controllerRequest.view.prompt());
                if (!controllerRequest.verifier.valid(message)) {
                    continue;
                } else {
                    controllerRequest.view.info(message);
                    if (controllerRequest.input.getString("Yes or No?").equalsIgnoreCase("yes")) {
                        results.add(controllerRequest.verifier.format(message));
                        break;

                    }
                }

            }
        }

        return results;
    }

    public List<ControllerRequest> createControllerRequests() {

        List<ControllerRequest> list = new ArrayList<>();
        list.add(new ControllerRequest(new VerifyingArticleNumber(),
                new ViewInputArticleNumber(), new ConsoleInputProvider()));
        list.add(new ControllerRequest(new VerifyingTitle(),
                new ViewInputTitle(), new ConsoleInputProvider()));
        list.add(new ControllerRequest(new VerifyingPrice(),
                new ViewInputPrice(), new ConsoleInputProvider()));
        list.add(new ControllerRequest(new VerifyingDescription(),
                new ViewInputDescription(), new ConsoleInputProvider()));

        return list;
    }
}
