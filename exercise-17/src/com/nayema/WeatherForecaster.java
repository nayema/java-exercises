package com.nayema;

public class WeatherForecaster {
    private double[] data;
    private ForecastingStrategy strategy;

    public WeatherForecaster(ForecastingStrategy strategy) {
        this.strategy = strategy;
    }

    public double[] setTemperatures(String[] temperatures) {
        int lengthOfTemperatures = temperatures.length - 1;
        double[] temperaturesArray = new double[lengthOfTemperatures];

        for (int i = 0; i < temperatures.length; i++) {
            temperaturesArray[i] = Double.parseDouble(temperatures[i + 1]);
        }
        return data = temperaturesArray;
    }

    public void printTemperature() {
        System.out.println("Tomorrow's temperature will be: " + strategy.forecast(data));
    }
}