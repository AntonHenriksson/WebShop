package se.jensen.anton.webshop.view;

public class ViewInputMenu implements ViewMenu {
    @Override
    public void showAddMenu() {

    }

    @Override
    public void showMenu() {
        System.out.println("""
                --------------------------
                Choose INPUT device
                --------------------------
                1  SCANNER
                2  JOPTIONPANE
                --------------------------
                IF NULL DEFAULT IS SCANNER
                --------------------------
                """);
    }
}
