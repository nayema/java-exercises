package com.nayema;

public class Actor {
    private static String[] name = {"Arnold Schwarzenegger", "Will Smith", "Anglenia Jolie", "Brad Pitt"};

    private Actor() {
    }

    public static void randomActorName() {
        int length = name.length;
        int random = (int)(Math.random() * length);
        String actorName = name[random];
        System.out.println(" I am " + actorName + "!");
    }
}
