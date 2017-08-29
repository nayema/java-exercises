package com.nayema;

public class Main {

    public static void main(String[] args) throws Exception {
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
                throw new Exception("Must enter AverageBased or MedianBased");
        }

        WeatherForecaster forecaster = new WeatherForecaster(strategy);
        forecaster.setTemperatures(args);
        forecaster.printTemperature();
    }
}