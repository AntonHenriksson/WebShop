package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.*;
import se.jensen.anton.webshop.view.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerRequest {
    private final Verifying verifier;
    private final ViewInput view;
    private final InputController input;


    public ControllerRequest(Verifying verifier,
                             ViewInput view,
                             InputController input) {
        this.verifier = verifier;
        this.view = view;
        this.input = input;
    }


    public List<String> requestData(List<ControllerRequest> controllerRequests) {
        List<String> results = new ArrayList();
        for (ControllerRequest controllerRequest : controllerRequests) {
            while (true) {
                System.out.println(controllerRequest.view.prompt());
                String message = controllerRequest.input.getInput();
                if (!controllerRequest.verifier.valid(message)) {
                    continue;
                } else {
                    controllerRequest.view.info(message);
                    if (controllerRequest.input.getInput().equalsIgnoreCase("yes")) {
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
        ControllerRequest DController = new ControllerRequest(new VerifyingDescription(), new ViewInputDescription(), new ScannerInput());
        ControllerRequest TController = new ControllerRequest(new VerifyingTitle(), new ViewInputTitle(), new ScannerInput());
        ControllerRequest PController = new ControllerRequest(new VerifyingPrice(), new ViewInputPrice(), new ScannerInput());
        ControllerRequest AController = new ControllerRequest(new VerifyingArticleNumber(), new ViewInputArticleNumber(), new ScannerInput());
        //atpd
        list.add(AController);
        list.add(TController);
        list.add(PController);
        list.add(DController);
        return list;
    }
}
