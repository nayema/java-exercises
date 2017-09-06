package com.nayema;

public class Coordinates {
    public int rowNumber;
    public int columnNumber;

    public Coordinates findCoordinates(int[][] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == 5) {
                    rowNumber = i;
                    columnNumber = j;
                }
            }
        }
        return new Coordinates();
    }

    public void printCoordinates(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j]);
            }
            System.out.println();
        }
    }
}
