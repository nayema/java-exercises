package com.nayema;

public class Main {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 6}, {3, 3, 1, 2, 1}, {1, 2, 3, 4, 5}};

        System.out.print("Coordinates for the number 5 in given 2D Array: ");
        System.out.println();
        Coordinates.printCoordinates(array);

        Coordinates.findCoordinatesFor5(array);
        System.out.println("rowNumber: " + Coordinates.rowNumber + " columnNumber: " + Coordinates.columnNumber);
    }
}
