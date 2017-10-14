package com.nayema.exercise_07;

public class Main {
    public static void main(String[] args) {

        String[] firstNames = {"Karen","Azucena","Isiah","Gwenda","Leonardo","Susana","Giuseppina","Lamar","Verdie","Kristle"};
        String[] lastNames = {"Planck","Kruse","Renfroe","Garbett","Shepherd","Geren","Castaneda","Valdivia","Brainard","Gossman"};

        int oneLength = firstNames.length;
        int twoLength = lastNames.length;

        int rand1 = (int)(Math.random() * oneLength);
        int rand2 = (int)(Math.random() * twoLength);

        String fullName = firstNames[rand1] + " " + lastNames[rand2];

        System.out.println("Your name is " + fullName + ".");
    }
}
