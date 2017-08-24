package com.nayema;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics();

        try {
            stats.setData(args);
            stats.getCalculations();
        } catch (InvalidNumberException e) {
            System.out.println(e.errorMessage);
            e.printStackTrace();
        }
    }
}
