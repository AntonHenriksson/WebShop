package se.jensen.anton.webshop.view;

import se.jensen.anton.webshop.controller.InputProvider;

import javax.swing.*;

public class ViewProviderGuiInputView implements ViewProvider {
    private String prompt;
    private final InputProvider inputProvider;

    public ViewProviderGuiInputView(String prompt, InputProvider inputProvider) {
        this.prompt = prompt;
        this.inputProvider = inputProvider;
    }


    @Override
    public void error() {
        this.prompt = prompt;
        JOptionPane.showMessageDialog(null, "Error. Please Follow: " + prompt);
    }


    @Override
    public String info(String message) {
        int choice;
        String[] mainMenuOption = {"Yes", "No"};
        String returnValue;
        choice = JOptionPane.showOptionDialog(null,
                "You typed: ---" + message + "--- is that correct?",
                "CONFIRMATION",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                mainMenuOption,
                mainMenuOption[0]
        );
        returnValue = choice == 0 ? "Yes" : "No";
        return returnValue;

    }

    @Override
    public String prompt() {
        return inputProvider.getString(prompt);
    }

}
