package com.nayema.menu_helper;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        MenuHelper menuHelper = new MenuHelper(app, "Dummy Program");

        menuHelper.registerCommand("What's 2 + 2?", app::calculate2Plus2);
        menuHelper.registerCommand("What's 3 + 3?", app::calculate3Plus3);

        menuHelper.displayWelcomeMessage();

        menuHelper.runInLoop();
    }
}
