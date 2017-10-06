package com.nayema;

public class Calculator {
    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double dividend, double divisor) {
        return dividend / divisor;
    }

    public double exponentiate(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
