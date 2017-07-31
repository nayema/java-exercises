package com.nayema;

import java.util.Scanner;

public class App {
    public void calculateDistance() {
        Point pointA = pointPrompt("a");
        Point pointB = pointPrompt("b");

        double distanceAB = distance(pointA, pointB);
        System.out.println("Distance: " + distanceAB);
    }

    private Point pointPrompt(String pointName) {
        double x = coordinatePrompt("x", pointName);
        double y = coordinatePrompt("y", pointName);
        double z = coordinatePrompt("z", pointName);
        return new Point(x, y, z);
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
