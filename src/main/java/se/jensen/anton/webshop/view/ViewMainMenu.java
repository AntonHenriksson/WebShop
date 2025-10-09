package se.jensen.anton.webshop.view;

public class ViewMainMenu implements ViewMenu {

    @Override
    public void showMenu() {
        System.out.println("""
                --------------------------
                    Welcome to the menu
                --------------------------
                1  View ALL Products
                2  Add NEW Product
                3  Remove EXISTING Product
                4  View DETAILS Of Product
                5  ---------QUIT----------
                --------------------------
                """);


    }

    public void showAddMenu() {
        System.out.println(""" 
                --------------------------
                 In what product Category:
                1  DryFlies
                2  NymphFlies
                3  StreamerFlies
                4  Back to Menu
                --------------------------
                """);


    }

}


