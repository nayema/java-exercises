package com.nayema;

public class Main {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 6}, {3, 3, 1, 2, 1}, {1, 2, 3, 4, 5}};

        Coordinates coordinates = new Coordinates();

        System.out.println("2D Array: ");
        coordinates.printCoordinates(array);

        coordinates.findCoordinates(array);
        System.out.println("rowNumber: " + coordinates.rowNumber + " columnNumber: " + coordinates.columnNumber);
    }
}
