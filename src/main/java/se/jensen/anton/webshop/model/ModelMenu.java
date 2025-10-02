package se.jensen.anton.webshop.model;

public class ModelMenu {


    boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void quit() {
        running = false;
    }


}
