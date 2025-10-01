package se.jensen.anton.webshop.controller;

import se.jensen.anton.webshop.model.VerifyingArticleNumber;
import se.jensen.anton.webshop.view.ViewInputArticleNumber;

public class ControllerArticleNumber {

    private final VerifyingArticleNumber verifier;
    private final ViewInputArticleNumber view;
    private final InputController input;

    // Constructor that actually sets the fields
    public ControllerArticleNumber(VerifyingArticleNumber verifier,
                                   ViewInputArticleNumber view,
                                   InputController input) {
        this.verifier = verifier;
        this.view = view;
        this.input = input;
    }

    public String requestArticleNum() {
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
