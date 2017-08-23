package com.nayema;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics();

        for (int i = 0; i < args.length; i++) {
            try {
                stats.setData(args);
            } catch (InvalidNumberException e) {
                e.printStackTrace();
            }
        }
        stats.getCalculations();
    }
}