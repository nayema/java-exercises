package com.nayema;

public class Product {
    String name;
    double price;
    final double TAX_RATE = 0.15; //15% sales tax

    public double taxAmount() {
        return price * TAX_RATE;
    }

    public double totalAmount() {
        return price + taxAmount();
    }
}
