package com.nayema.exercise_12;

public class Main {

    public static void main(String[] args) {
        MenuHelper menuHelper = new MenuHelper("Exercise 12 - Geometry Part 2");

        App app = new App();
        menuHelper.registerCommand("Calculate distance between 2 3D points", app::calculateDistance);

        menuHelper.displayWelcomeMessage();

        menuHelper.runInLoop();
    }
}
