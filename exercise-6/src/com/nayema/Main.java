package com.nayema;

import java.util.Scanner;

public class Main {
    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which Fibonacci number do you want the sequence to go up to?");
        int number = scan.nextInt();

        System.out.println("The Sequence is: ");
        for (int i = 1; i <= number; i++) {
            System.out.print(fib(i));

            if (i < number) {
                System.out.print(", ");
            }
        }
    }
}
