package com.nayema;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class WeatherForecaster {
    private double[] data;
    private ForecastingStrategy strategy;

    public WeatherForecaster(ForecastingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setTemperatures(String[] temperatures) {
        data = new double[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            data[i] = Double.parseDouble(temperatures[i]);
        }

        System.out.println("Input Array: " + Arrays.toString(data));
        double[] sortedArray = sortArrays(data);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }

    public void printTemperature() {

        double tomorrowsTemperature = strategy.forecast(data);
        BigDecimal bigDecimal = new BigDecimal(tomorrowsTemperature);
        BigDecimal formattedTemperature = bigDecimal.round(new MathContext(2, RoundingMode.UP));
        System.out.println("Tomorrow's temperature will be " + formattedTemperature + " \u00b0C.");
    }

    private double[] sortArrays(double[] temperatures) {
        double temp;

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 1; j < temperatures.length - i; j++) {
                if (temperatures[j - 1] > temperatures[j]) {
                    temp = temperatures[j - 1];
                    temperatures[j - 1] = temperatures[j];
                    temperatures[j] = temp;
                }
            }
        }
        return temperatures;
    }
}