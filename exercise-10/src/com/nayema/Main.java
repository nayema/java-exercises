package com.nayema;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the product name?");
        String productName = userInput.nextLine();

        System.out.println("What is the product price?");

        Product product = new Product();
        product.taxAmount();
        DecimalFormat twoD = new DecimalFormat("0.00");
        double finalPrice = product.price;
        System.out.println("The " + productName + " costs a total of $" + twoD.format(finalPrice));
    }
}
