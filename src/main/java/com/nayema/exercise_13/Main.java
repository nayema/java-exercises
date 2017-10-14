package com.nayema.exercise_13;

public class Main {

    public static void main(String[] args) {
        MenuHelper menuHelper = new MenuHelper("Exercise 13 - Geometry Part 3");
        App app = new App();

        menuHelper.registerCommand("Determine if a triangle is isosceles", app::determineIsosceles);

        menuHelper.displayWelcomeMessage();

        menuHelper.runInLoop();
    }
}
