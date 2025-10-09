package se.jensen.anton.webshop.controller;

import javax.swing.*;

public class GuiInputProvider implements InputProvider {
    @Override
    public String getString(String prompt) {
        return JOptionPane.showInputDialog(null, prompt, "WebShop Input", JOptionPane.QUESTION_MESSAGE);
    }
}
