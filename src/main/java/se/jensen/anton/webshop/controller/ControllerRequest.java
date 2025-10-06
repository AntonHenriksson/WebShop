package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.Verifying;
import se.jensen.anton.webshop.view.ViewInput;

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


    public String requestData() {
        while (true) {
            System.out.println(view.prompt());
            String message = input.getInput();
            if (!verifier.valid(message)) {
                continue;
            } else {
                view.info(message);
                if (input.getInput().equalsIgnoreCase("yes")) {
                    return verifier.format(message);
                }
            }

        }

    }
}
