package com.nayema;

public class Actor {
    private static String[] possibleNames = {
            "Arnold Schwarnezeggar",
            "Angelina Jolie",
            "Brad Pitt",
            "Will Smith",
            "Leonardo Decaprio",
            "Johny Depp",
            "Lisa Ray",
            "Jamie Foxx",
            "Tom Hanks",
            "Matt Damon",
            "Jennifer Lawrence",
            "Robin Williams",
            "Ben Affleck",
            "Bruce Willis",
            "Vin Diesel",
            "Julia Roberts",
            "Megan Fox"
    };

    public static Actor createRandomActor() {
        return new Actor(getActorName());
    }

    private static String getActorName() {
        int length = possibleNames.length;
        int random = (int) (Math.random() * length);
        return possibleNames[random];
    }

    String name;

    private Actor(String name) {
        this.name = name;
    }
}
