package com.nayema;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is the x coordinate for Point a?");
        double aX = scan.nextDouble();
        System.out.println("What is the y coordinate for Point a?");
        double aY = scan.nextDouble();

        System.out.println("What is the x coordinate for Point b?");
        double bX = scan.nextDouble();
        System.out.println("What is the y coordinate for Point b?");
        double bY = scan.nextDouble();

        System.out.println("What is the x coordinate for Point c?");
        double cX = scan.nextDouble();
        System.out.println("What is the y coordinate for Point c?");
        double cY = scan.nextDouble();

        Triangle triangle = new Triangle(new Point(aX, aY), new Point(bX, bY), new Point(cX, cY));

        ArrayList<Double> lengths = triangle.calculateLengthsOfSides();
        ArrayList<Double> angles = triangle.calculateAngles();

        DecimalFormat formatter = new DecimalFormat("0.00");

        System.out.println("Lengths of sides: " + formatter.format(lengths.get(0)) + ", " + formatter.format(lengths.get(1)) + ", " + formatter.format(lengths.get(2)));
        System.out.println("Angles at each point: " + formatter.format(angles.get(0)) + ", " + formatter.format(angles.get(1)) + ", " + formatter.format(angles.get(2)));
        System.out.println("Area: " + formatter.format(triangle.calculateArea()));
    }
}