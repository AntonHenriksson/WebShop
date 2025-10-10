package se.jensen.anton.webshop.view;

import javax.swing.*;

public class ViewProviderGuiInputView implements ViewProvider {
    private String prompt;

    public ViewProviderGuiInputView(String prompt) {
        this.prompt = prompt;
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
        return JOptionPane.showInputDialog(prompt);
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
