package com.nayema;

public class Main {

    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.make = "Toyota";
        toyota.model = "Corolla";
        toyota.year = 2004;
        System.out.println(toyota.description());

        Car honda = new Car();
        honda.make = "Honda";
        honda.model = "Civic";
        honda.year = 2015;
        System.out.println(honda.description());
    }
}
