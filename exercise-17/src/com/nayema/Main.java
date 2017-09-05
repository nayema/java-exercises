package com.nayema;

public class Main {

    public static void main(String[] args) throws InvalidStrategyException, InvalidNumberException {
        String strategyFlag = args[0];
        ForecastingStrategy strategy;

        switch (strategyFlag) {
            case "AverageBased":
                strategy = new AverageBasedStrategy();
                break;
            case "MedianBased":
                strategy = new MedianBasedStrategy();
                break;
            case "YesterdayBased":
                strategy = new YesterdayBasedStrategy();
                break;
            default:
                throw new InvalidStrategyException("Must enter AverageBased, MedianBased or YesterdayBased");
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