package com.nayema;

import java.util.Scanner;

public class App {
    public void calculateDistance() {
        double xA = coordinatePrompt("x", "a");
        double yA = coordinatePrompt("y", "a");
        double zA = coordinatePrompt("z", "a");
        double xB = coordinatePrompt("x", "b");
        double yB = coordinatePrompt("y", "b");
        double zB = coordinatePrompt("z", "b");

        Point pointA = new Point(xA, yA, zA);
        Point pointB = new Point(xB, yB, zB);

        double distanceAB = distance(pointA, pointB);
        System.out.println("Distance: " + distanceAB);
    }

    private double coordinatePrompt(String coordinate, String point) {
        System.out.println("What is the " + coordinate + " coordinate for Point " + point + "?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private double distance(Point starting, Point ending) {
        return Math.sqrt(Math.pow(ending.x - starting.x, 2) + Math.pow(ending.y - starting.y, 2)+ Math.pow(ending.z - starting.z, 2));
    }
}
