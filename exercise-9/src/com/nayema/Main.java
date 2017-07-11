package com.nayema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Car simulator!");

        Car toyCar = new Car();
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("quit")) {
            System.out.println("What would you like to do next? accelerate/brake/quit");
            command = scanner.nextLine();

            switch (command) {
                case "accelerate":
                    toyCar.accelerate();
                    System.out.println("Current speed is " + toyCar.currentSpeed + " km/h");
                    break;
                case "brake":
                    toyCar.brake();
                    System.out.println("Current speed is " + toyCar.currentSpeed + " km/h");
                    break;
                default:
                    System.out.println("Goodbye.");
                    break;
            }
        }
    }
}
