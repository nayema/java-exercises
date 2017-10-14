package com.nayema.exercise_13;

import java.util.Scanner;

public class App {
    public void determineIsosceles() {
        Point pointA = pointPrompt("a");
        Point pointB = pointPrompt("b");
        Point pointC = pointPrompt("c");

        double distanceAB = distance(pointA, pointB);
        double distanceBC = distance(pointB, pointC);
        double distanceAC = distance(pointA, pointC);

        if ((distanceAB == distanceBC)||(distanceAB==distanceAC)||(distanceBC==distanceAC)) {
            System.out.println("This is an isosceles triangle.");
        } else {
            System.out.println("This is not an isosceles triangle.");
        }
    }

    private Point pointPrompt(String pointName) {
        double x = coordinatePrompt("x", pointName);
        double y = coordinatePrompt("y", pointName);
        return new Point(x, y);
    }

    private double coordinatePrompt(String coordinate, String point) {
        System.out.println("What is the " + coordinate + " coordinate for Point " + point + "?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private double distance(Point starting, Point ending) {
        return Math.sqrt(Math.pow(ending.x - starting.x, 2) + Math.pow(ending.y - starting.y, 2));
    }
}
