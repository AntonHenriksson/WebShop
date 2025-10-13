package se.jensen.anton.webshop;

import se.jensen.anton.webshop.controller.ConsoleInputProvider;
import se.jensen.anton.webshop.controller.ControllerRequest;
import se.jensen.anton.webshop.controller.GuiInputProvider;
import se.jensen.anton.webshop.controller.MainMenuController;
import se.jensen.anton.webshop.model.ModelMenu;
import se.jensen.anton.webshop.view.ViewMenuJOptionMenu;
import se.jensen.anton.webshop.view.ViewMenuOption;
import se.jensen.anton.webshop.view.ViewProductConsole;
import se.jensen.anton.webshop.view.ViewProductGui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ModelMenu modelMenu = new ModelMenu();

        // Let the user choose the mode in a GUI dialog at startup
        String[] modes = {"Console", "GUI"};
        int modeChoice = JOptionPane.showOptionDialog(
                null,
                "Select interface mode:",
                "WebShop Launcher",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                modes,
                modes[0]
        );

        if (modeChoice == 1) {
            // === GUI MODE ===
            ViewMenuJOptionMenu view = new ViewMenuJOptionMenu();
            GuiInputProvider input = new GuiInputProvider();
            ViewProductGui viewProductGui = new ViewProductGui();

            MainMenuController mainMenu = new MainMenuController(view, modelMenu, input);
            mainMenu.mainMenu(new ControllerRequest(null, null, input), viewProductGui);

        } else {
            // === CONSOLE MODE ===
            ConsoleInputProvider consoleInput = new ConsoleInputProvider();
            ViewMenuOption viewMenuOption = new ViewMenuOption();
            ViewProductConsole viewProductConsole = new ViewProductConsole();

            MainMenuController mainMenu = new MainMenuController(viewMenuOption, modelMenu, consoleInput);
            mainMenu.mainMenu(ControllerRequest.dummy(), viewProductConsole);
        }
    }
}
