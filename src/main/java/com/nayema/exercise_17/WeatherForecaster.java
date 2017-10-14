package com.nayema.exercise_17;

import java.text.DecimalFormat;
import java.util.Arrays;

public class WeatherForecaster {
    private double[] data;
    private ForecastingStrategy strategy;

    public WeatherForecaster(ForecastingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setTemperatures(String[] temperatures) throws InvalidNumberException {
        data = new double[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            try {
                data[i] = Double.parseDouble(temperatures[i]);
            } catch (NumberFormatException e) {
                throw new InvalidNumberException(temperatures[i] + " is not a valid number!");
            }
        }

        System.out.println("Input Array: " + Arrays.toString(data));
        double[] sortedArray = BubbleSort.sort(data);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }

    public void printTemperature() {

        double temperature = strategy.forecast(data);
        DecimalFormat formatter = new DecimalFormat("0.00");
        String formattedTemperature = formatter.format(temperature);
        System.out.println("Tomorrow's temperature will be " + formattedTemperature + " \u00b0C.");
    }
}