package com.nayema.exercise_17;

public class BubbleSort {
    public static double[] sort(double[] items) {
        double temp;

        for (int i = 0; i < items.length; i++) {
            for (int j = 1; j < items.length - i; j++) {
                if (items[j - 1] > items[j]) {
                    temp = items[j - 1];
                    items[j - 1] = items[j];
                    items[j] = temp;
                }
            }
        }
        return items;
    }
}
