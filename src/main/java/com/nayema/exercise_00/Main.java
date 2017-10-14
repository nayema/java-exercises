package com.nayema.exercise_00;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the make of your car?");
        myCar.make = scanner.nextLine();

        System.out.println("What is the model of your car?");
        myCar.model = scanner.nextLine();

        System.out.println("What is the year of your car?");
        myCar.year = scanner.nextInt();

        System.out.println("Your car is a " + myCar.description());
    }
}
