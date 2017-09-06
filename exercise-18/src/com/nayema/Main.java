package com.nayema;

public class Main {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 6}, {3, 3, 1, 2, 1}, {1, 2, 3, 4, 5}};

        System.out.println("2D Array: ");
        printArray(array);

        Coordinates coordinates = findCoordinates(array, 5);
        System.out.println("rowNumber: " + coordinates.rowNumber + " columnNumber: " + coordinates.columnNumber);
    }

    public static Coordinates findCoordinates(int[][] numbers, int searchFor) {
        int rowNumber = -1;
        int columnNumber = -1;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == searchFor) {
                    rowNumber = i;
                    columnNumber = j;
                }
            }
        }
        return new Coordinates(rowNumber, columnNumber);
    }

    public static void printArray(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j]);
            }
            System.out.println();
        }
    }
}
