package com.nayema;

import java.util.Scanner;

public class Product {
    double price;
    final double tax = 1.15; //15% sales tax

    public void taxAmount() {
        Scanner scanner = new Scanner(System.in);
        double productPrice = scanner.nextInt();
        price = productPrice * tax;
    }
}
