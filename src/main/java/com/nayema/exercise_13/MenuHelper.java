package com.nayema.exercise_13;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuHelper {
    private String appName;
    private ArrayList<Command> registeredCommands = new ArrayList<>();

    public MenuHelper(String appName) {
        this.appName = appName;
        registeredCommands.add(new Command("Exit", null));
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to " + appName + "!");
        System.out.println(". . .-. . . .-. .  . .-. \n" +
                "|\\| |-|  |  |-  |\\/| |-| \n" +
                "' ` ` '  `  `-' '  ` ` ' ");
    }

    public void registerCommand(String commandName, Runnable commandToRun) {
        this.registeredCommands.add(new Command(commandName, commandToRun));
    }

    public int promptForCommand() {
        System.out.println("\nPlease select a command:");

        for (int i = 0; i < registeredCommands.size(); i++) {
            System.out.println(i + ") " + registeredCommands.get(i).name);
        }

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void runInLoop() {
        int commandSelected;
        while (true) {
            commandSelected = promptForCommand();
            if (commandSelected == 0) {
                System.out.println("\nGoodbye!");
                break;
            }
            Runnable commandToRun = registeredCommands.get(commandSelected).commandToRun;
            commandToRun.run();
        }
    }

    private class Command {
        String name;
        Runnable commandToRun;

        public Command(String name, Runnable commandToRun) {
            this.name = name;
            this.commandToRun = commandToRun;
        }
    }
}
