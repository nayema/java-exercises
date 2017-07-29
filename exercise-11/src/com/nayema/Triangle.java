package com.nayema;

import java.util.ArrayList;

public class Triangle {
    Point a;
    Point b;
    Point c;
    double lengthAB;
    double lengthBC;
    double lengthAC;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ArrayList<Double> calculateLengthsOfSides() {
        lengthAB = distance(a, b);
        lengthBC = distance(b, c);
        lengthAC = distance(a, c);

        ArrayList<Double> lengths = new ArrayList<Double>(3);
        lengths.add(lengthAB);
        lengths.add(lengthBC);
        lengths.add(lengthAC);
        return lengths;
    }

    public ArrayList<Double> calculateAngles() {
        double angleA = angle(lengthBC, lengthAC, lengthAB);
        double angleB = angle(lengthAC, lengthAB, lengthBC);
        double angleC = 180 - (angleA + angleB);

        ArrayList<Double> areas = new ArrayList<Double>(3);
        areas.add(angleA);
        areas.add(angleB);
        areas.add(angleC);
        return areas;
    }

    public double calculateArea() {
        return 0.5 * ((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y));
    }

    private double distance(Point starting, Point ending) {
        return Math.sqrt(Math.pow(ending.x - starting.x, 2) + Math.pow(ending.y - starting.y, 2));
    }

    private double angle(double a, double b, double c) {
        return Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
    }
}
