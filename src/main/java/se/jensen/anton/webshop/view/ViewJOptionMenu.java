package se.jensen.anton.webshop.view;

import javax.swing.*;

public class ViewJOptionMenu implements ViewMenu {
    @Override
    public int guiMenuChoice() {
        int choice;
        String[] mainMenuOption = {"View All", "Add", "Remove", "View Specific", "Exit"};
        choice = JOptionPane.showOptionDialog(null,
                "What do you want to do?",
                "WebShopADMINMENU",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                mainMenuOption,
                mainMenuOption[0]
        );
        return (choice == JOptionPane.CLOSED_OPTION) ? -1 : choice + 1;


    }


    @Override
    public int guiAddMenuChoice() {
        int choice;
        String[] mainMenuOption = {"Dry Fly", "Nymph Fly", "Streamer Fly", "Back To Menu"};
        choice = JOptionPane.showOptionDialog(null,
                "What do you want to add?",
                "WebShopADMINMENU",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                mainMenuOption,
                mainMenuOption[0]
        );
        return (choice == JOptionPane.CLOSED_OPTION) ? -1 : choice + 1;
    }
}
