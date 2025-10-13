package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.*;
import se.jensen.anton.webshop.view.ViewProvider;
import se.jensen.anton.webshop.view.ViewProviderGuiInputView;
import se.jensen.anton.webshop.view.ViewProviderScanner;

import java.util.ArrayList;
import java.util.List;

public class ControllerRequest {
    private final Verifying verifier;
    private final ViewProvider view;
    private final InputProvider input;


    public ControllerRequest(Verifying verifier,
                             ViewProvider view,
                             InputProvider input) {
        this.verifier = verifier;
        this.view = view;
        this.input = input;
    }


    public List<String> requestData(List<ControllerRequest> controllerRequests) {
        List<String> results = new ArrayList<>();
        for (ControllerRequest controllerRequest : controllerRequests) {
            while (true) {
                String message = controllerRequest.view.prompt();
                if (!controllerRequest.verifier.valid(message)) {
                    controllerRequest.view.error();
                    continue;
                } else {
                    if (controllerRequest.view.info(message).equalsIgnoreCase("yes")) {
                        results.add(message);
                        break;

                    }
                }
            }

        }
        return results;
    }

    public List<ControllerRequest> getRequestForCurrentMode() {
        if (input instanceof GuiInputProvider guiInput) {
            return guiRequests(guiInput);
        } else {
            return createControllerRequests();
        }
    }

    public static List<ControllerRequest> createControllerRequests() {
        InputProvider scanner = new ConsoleInputProvider();
        List<ControllerRequest> list = new ArrayList<>();
        list.add(new ControllerRequest(new VerifyingArticleNumber(),
                new ViewProviderScanner("Enter articlenumber for the Product, 5 digits", scanner), scanner));
        list.add(new ControllerRequest(new VerifyingTitle(),
                new ViewProviderScanner("Enter a title with maximum 15 characters", scanner), scanner));
        list.add(new ControllerRequest(new VerifyingPrice(),
                new ViewProviderScanner("Enter the price using following example 4.99", scanner), scanner));
        list.add(new ControllerRequest(new VerifyingDescription(),
                new ViewProviderScanner("Enter description for the Product, example: This works well for trout", scanner), scanner));

        return list;
    }

    public static List<ControllerRequest> guiRequests(InputProvider input) {
        List<ControllerRequest> list = new ArrayList<>();
        list.add(new ControllerRequest(new VerifyingArticleNumber(),
                new ViewProviderGuiInputView("Enter articlenumber for the Product, 5 digits", input), input));
        list.add(new ControllerRequest(new VerifyingTitle(),
                new ViewProviderGuiInputView("Enter a title with maximum of 15 characters", input), input));
        list.add(new ControllerRequest(new VerifyingPrice(),
                new ViewProviderGuiInputView("Enter the price using following example, 4.99", input), input));
        list.add(new ControllerRequest(new VerifyingDescription(),
                new ViewProviderGuiInputView("Enter description for the Product, example: This works well for trout", input), input));

        return list;
    }

    public static ControllerRequest dummy() {
        return new ControllerRequest(
                new Verifying() {
                    @Override
                    public boolean valid(String input) {
                        return true;
                    }

                    @Override
                    public String format(String input) {
                        return input;
                    }
                },
                new ViewProvider() {
                    @Override
                    public String prompt() {
                        return "";
                    }

                    @Override
                    public void error() {
                    }

                    @Override
                    public String info(String message) {
                        return "";
                    }
                },
                new InputProvider() {
                    @Override
                    public String getString(String prompt) {
                        return "";
                    }
                }
        );
    }
}
