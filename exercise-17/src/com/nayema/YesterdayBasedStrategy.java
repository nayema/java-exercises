package com.nayema;

public class YesterdayBasedStrategy implements ForecastingStrategy {
    public double forecast(double[] temperatures) {
        double[] sortedArray = BubbleSort.sort(temperatures);

        int lastIndex = sortedArray.length - 1;
        return sortedArray[lastIndex];
    }
}
