package com.nayema;

public class Car {
    String make; //These are attributes
    String model;
    int year;

    public String description() { //This is a method
        return make + " " + model + " " + year;
    }
}
