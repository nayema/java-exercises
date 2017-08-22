package com.nayema;

public class Main {

    public static void main(String[] args) {

        Actor actor = Actor.createRandomActor();

        System.out.println("I am " + actor.name + "!");
    }
}
