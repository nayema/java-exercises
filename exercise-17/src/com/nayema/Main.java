package com.nayema;

public class Main {

    public static void main(String[] args) throws Error {
        String strategyFlag = args[0];
        ForecastingStrategy strategy;

        switch (strategyFlag) {
            case "AverageBased":
                strategy = new AverageBasedStrategy();
                break;
            case "MedianBased":
                strategy = new MedianBasedStrategy();
                break;
            default:
                throw new Error("Must enter AverageBased or MedianBased");
        }

        WeatherForecaster forecaster = new WeatherForecaster(strategy);

        String[] temperatures = new String[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            temperatures[i - 1] = args[i];
        }

        forecaster.setTemperatures(temperatures);
        forecaster.printTemperature();
    }
}