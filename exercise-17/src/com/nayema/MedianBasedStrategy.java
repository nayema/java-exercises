package com.nayema;

public class MedianBasedStrategy implements ForecastingStrategy {
    public double forecast(double[] temperatures) {
        double[] sortedArray = BubbleSort.sort(temperatures);

        double median;
        int length = sortedArray.length;

        if (length % 2 == 0) {
            int centeredNumber1 = (length - 1) / 2;
            int centeredNumber2 = length / 2;

            median = (sortedArray[centeredNumber1] + sortedArray[centeredNumber2]) / 2;
        } else {
            int centeredNumber = length / 2;

            median = sortedArray[centeredNumber];
        }
        return median;
    }
}