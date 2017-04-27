package com.nayema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which letter would you like to use?");
        char letter = scanner.next().charAt(0); //This could have been also the following:
        // String letter = scanner.nextLine();

        System.out.println("How large is your grid?");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) { // 'j'loop prints on the next line.
            // 'i' loop prints on the same line.
            for(int j = 0; j < number; j++) {
                System.out.print(letter);
            }
            System.out.print('\n'); // '\n' = single new line.
        }
    }

}