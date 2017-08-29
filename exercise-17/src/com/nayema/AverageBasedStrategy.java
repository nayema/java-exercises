package com.nayema;

public class AverageBasedStrategy implements ForecastingStrategy {
    public double forecast(double[] temperatures) {
        double sum = 0.0;
        for (double a : temperatures) {
            sum = +a;
        }
        return sum / temperatures.length;
    }
}