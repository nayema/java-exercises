package com.nayema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Fibonacci number do you want?");
        int number = scanner.nextInt();

        int num = 0;
        int num2 = 1;
        for (int i = 0; i < number; i ++) {
            int fibonacci = num + num2;
            num = num2;
            num2 = fibonacci;

        }

        System.out.println("The " + number + "th Fibonacci number is: " + num);

    }
}
