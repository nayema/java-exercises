package com.nayema;

public class Triangle {
    double s;
    double lengthA, lengthB, lengthC;
    double area;
    Point point = new Point();

    public String lengthsOfSides() {
        lengthA = Math.sqrt(Math.pow(point.getX2()- point.getX1(),2) + (Math.pow(point.getY2()-point.getY1(),2)));
        lengthB = Math.sqrt(Math.pow(point.getX3()-point.getX2(),2) + (Math.pow(point.getY3()-point.getY2(),2)));
        lengthC = Math.sqrt((Math.pow(lengthA,2)) + (Math.pow(lengthB,2)));
        return "Length of sides: " + lengthA + ", " + lengthB + ", " + lengthC;
    }
    public String area() {
        s = (lengthA + lengthB + lengthC)/2;
        area = Math.sqrt(s*(s-lengthA)*(s-lengthB)*(s-lengthC));
        return "Area: " + area;
    }
}
