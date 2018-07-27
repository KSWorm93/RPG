/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gameEngine.CommandHandler;

import java.util.Scanner;

/**
 *
 * @author kasper
 */
public class CleanOutputHelper {

    private Scanner scan;
    private CommandHandler commander;
    private PrintHelper printer;

    public CleanOutputHelper(Scanner scan, CommandHandler commander, PrintHelper printer) {
        this.scan = scan;
        this.commander = commander;
        this.printer = printer;
    }

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
        printer.print( "\nPress enter to continue.");
        String enter;
        enter = scan.nextLine();

        while (!enter.equals("")) {
            checkForCommand(enter);
            printer.print("\nPlease press enter.");
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
                printer.print("\033[H\033[2J");
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
