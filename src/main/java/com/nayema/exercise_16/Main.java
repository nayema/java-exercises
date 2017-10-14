package com.nayema.exercise_16;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics();

        try {
            stats.setData(args);
            stats.printStats();
        } catch (InvalidNumberException e) {
            System.out.println(e.errorMessage);
            e.printStackTrace();
        }
    }
}
