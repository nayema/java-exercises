package com.nayema.exercise_10;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        System.out.println("What is the product name?");
        product.name = scanner.nextLine();

        System.out.println("What is the product price?");
        product.price = scanner.nextDouble();

        product.totalAmount();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("The " + product.name + " costs a total of " + currency.format(product.totalAmount()));
    }
}
