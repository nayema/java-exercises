package com.nayema;

import java.util.Arrays;

public class MedianBasedStrategy implements ForecastingStrategy {
    public double forecast(double[] temperatures) {
        Arrays.sort(temperatures);

        double median;
        int length = temperatures.length;

        if (length % 2 == 0) {
            int centeredNumber1 = (length - 1) / 2;
            int centeredNumber2 = length / 2;

            median = (temperatures[centeredNumber1] + temperatures[centeredNumber2]) / 2;
        } else {
            int centeredNumber = length / 2;

            median = temperatures[centeredNumber];
        }
        return median;
    }
}