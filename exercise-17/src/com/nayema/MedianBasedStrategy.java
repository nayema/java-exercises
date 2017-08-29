package com.nayema;

public class MedianBasedStrategy implements ForecastingStrategy {
    public double forecast(double[] temperatures) {
        int middle = temperatures.length / 2;

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures.length % 2 == 1) {
                return temperatures[middle];
            }
        }
        return (temperatures[middle - 1] + temperatures[middle]) / 2.0;
    }
}