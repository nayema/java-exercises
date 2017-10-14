package com.nayema.exercise_04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number.");
        int number = scanner.nextInt();
        System.out.println("Here is the output:");

        for (int i = number; i >= 0; i--) {
            if(i % 2 == 0) {
                System.out.println(i * i);
            }
        }
    }
}
