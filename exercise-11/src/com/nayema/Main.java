package com.nayema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Point point = new Point();

        Scanner scan = new Scanner(System.in);

        System.out.println("What is the x coordinate for side a?");
        point.x1 = scan.nextDouble();
        System.out.println("What is the y coordinate for side a?");
        point.y1 = scan.nextDouble();

        System.out.println("What is the x coordinate for side b?");
        point.x2 = scan.nextDouble();
        System.out.println("What is the y coordinate for side b?");
        point.y2 = scan.nextDouble();

        System.out.println("What is the x coordinate for side c?");
        point.x3 = scan.nextDouble();
        System.out.println("What is the y coordinate for side c?");
        point.y3 = scan.nextDouble();

        System.out.println(triangle.lengthsOfSides());
        System.out.println(triangle.area());
    }
}
