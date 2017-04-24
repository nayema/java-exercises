package com.nayema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("What is your name?");

        Scanner nameScanner = new Scanner(System.in); //Creates a new scanner
        String name = nameScanner.nextLine(); //Asks to put your name
        int length = name.length(); //counts the length of the String

        System.out.println("Hello " + name + " you have " + length + " letters in your name.");
    }
}
