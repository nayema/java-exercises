package com.nayema.exercise_16;

import java.text.DecimalFormat;

class InvalidNumberException extends Exception {
    public String errorMessage;

    public InvalidNumberException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

public class Statistics {
    private double[] data;
    private int size;

    public void setData(String[] listOfNumbers) throws InvalidNumberException {
        data = new double[listOfNumbers.length];

        for (int i = 0; i < listOfNumbers.length; i++) {
            double datum;
            try {
                datum = Double.parseDouble(listOfNumbers[i]);
            } catch (NumberFormatException e) {
                throw new InvalidNumberException("Error: " + listOfNumbers[i] + " is not a valid number!");
            }
            data[i] = datum;
        }
        size = data.length;
    }

    public void printStats() {
        DecimalFormat formatter = new DecimalFormat("0.00");

        System.out.println("Mean: " + formatter.format(calculateMean()));
        System.out.println("Median: " + formatter.format(calculateMedian()));
        System.out.println("Mode: " + formatter.format(calculateMode()));
        System.out.println("Standard Deviation: " + formatter.format(calculateStandardDeviation()));
        System.out.println("Variance: " + formatter.format(calculateVariance()));
    }

    private double calculateMean() {
        double sum = 0.0;
        for (double a : data) {
            sum += a;
        }
        return sum / size;
    }

    private double calculateVariance() {
        double mean = calculateMean();
        double temp = 0;
        for (double a : data)
            temp += (a - mean) * (a - mean);
        return temp / (size - 1);
    }

    private double calculateStandardDeviation() {
        return Math.sqrt(calculateVariance());
    }

    private double calculateMedian() {
        int middle = size / 2;
        if (size % 2 == 1) {
            return data[middle];
        } else {
            return (data[middle - 1] + data[middle]) / 2.0;
        }
    }

    private double calculateMode() {
        double maxValue = 0;
        double maxCount = 0;

        for (int i = 0; i < size; ++i) {
            int count = 0;
            for (int j = 0; j < size; ++j) {
                if (data[j] == data[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = data[i];
            }
        }
        return maxValue;
    }
}


