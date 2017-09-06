package com.nayema;

public class Coordinates {
    public static int rowNumber;
    public static int columnNumber;

    public Coordinates(int rowNumber, int columnNumber) {
        Coordinates.rowNumber = rowNumber;
        Coordinates.columnNumber = columnNumber;
    }

    public static Coordinates findCoordinatesFor5(int[][] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == 5) {
                    rowNumber = i;
                    columnNumber = j;
                }
            }
        }
        return new Coordinates(rowNumber, columnNumber);
    }

    public static void printCoordinates(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j]);
            }
            System.out.println();
        }
    }
}
