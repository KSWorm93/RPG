/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author kasper
 */
public class CleanOutputHelper {

    Scanner scan = new Scanner(System.in, "UTF-8");
    CommandHandler commander = new CommandHandler();

    /**
     * Wait for user to press enter
     */
    public void waitForEnter() {
        waitEnter();
    }

    /**
     * Moves old outputs out of the way. They can be seen by scrolling up.
     */
    public void clear() {
        clearScreen();
    }

    /**
     * calls both waitForEnter() and clear()
     */
    public void waitClear() {
        waitForEnter();
        clearScreen();
    }

    /**
     * Wait until user has pressed enter
     */
    private void waitEnter() {
        System.out.println("\nPress enter to continue.");
        String enter;
        enter = scan.nextLine();

        while (!enter.equals("")) {
            checkForCommand(enter);
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
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    /**
     * Check in input is a command
     * @param input 
     */
    private void checkForCommand(String input) {
        if (commander.checkForCommand(input)) {
            commander.executeCommand(input);
        }
    }

}
