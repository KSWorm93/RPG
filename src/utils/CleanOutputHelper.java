/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gameEngine.CommandHandler;

import java.util.Scanner;

/**
 * @author kasper
 */
public class CleanOutputHelper {

    private Scanner scan = new Scanner(System.in, "UTF-8");

    /**
     * Wait for user to press enter
     *
     * @param commandHandler If wanting to check if input is a command
     */
    public void waitForEnter(CommandHandler commandHandler) {
        System.out.println("\nPress enter to continue.");
        String enter;
        enter = scan.nextLine();

        while (!enter.equals("")) {
            checkForCommand(enter, commandHandler);
            System.out.println("\nPlease press enter.");
            enter = scan.nextLine();
        }
    }

    /**
     * Wait for user to press enter
     */
    public void waitForEnter() {
        System.out.println("\nPress enter to continue.");
        String enter;
        enter = scan.nextLine();

        while (!enter.equals("")) {
            System.out.println("\nPlease press enter.");
            enter = scan.nextLine();
        }
    }

    /**
     * Moves old outputs out of the way. They can be seen by scrolling up.
     */
    public void clear() {
        clearScreen();
    }

    /**
     * Waits until user presses 'Enter/Return' and then clears the screen
     *
     * @param commandHandler If wanting to check if input is a command
     */
    public void waitClear(CommandHandler commandHandler) {
        waitForEnter(commandHandler);
        clearScreen();
    }

    /**
     * Waits until user presses 'Enter/Return' and then clears the screen
     */
    public void waitClear() {
        waitForEnter();
        clearScreen();
    }

    /**
     * Wait until user has pressed enter
     * Checks if input is a command
     */
    private void waitEnter(CommandHandler commandHandler) {
        System.out.println("\nPress enter to continue.");
        String enter;
        enter = scan.nextLine();

        while (!enter.equals("")) {
            checkForCommand(enter, commandHandler);
            System.out.println("\nPlease press enter.");
            enter = scan.nextLine();
        }
    }

    /**
     * Wait until user has pressed enter
     */
    private void waitEnter() {
        System.out.println("\nPress enter to continue.");
        String enter;
        enter = scan.nextLine();

        while (!enter.equals("")) {
            System.out.println("\nPlease press enter.");
            enter = scan.nextLine();
        }
    }

    /**
     * Clear commands for windows and unix/linux systems
     */
    private void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    /**
     * Check in input is a command
     *
     * @param input
     */
    private void checkForCommand(String input, CommandHandler commandHandler) {
        if (commandHandler.checkForCommand(input)) {
            commandHandler.executeCommand(input);
        }
    }
}
