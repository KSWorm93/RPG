/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import java.util.Scanner;

import utils.ClassHandler;
import utils.CleanOutputHelper;
import utils.CommandHandler;
import utils.LevelUpHelper;
import utils.PrintHelper;
import utils.QuestHandler;
import utils.StoryHandler;

/**
 * @author kasper
 */
public class Main {

    private static PrintHelper printer;
    private static CommandHandler commandHandler;
    private static Scanner scan;
    private static String input;
    private static QuestHandler questHandler;
    private static ClassHandler chosenClass;
    private static StoryHandler story;
    private static CleanOutputHelper cleanOutput;
    private static LevelUpHelper leveler;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scan = new Scanner(System.in, "UTF-8");
        printer = new PrintHelper();
        commandHandler = new CommandHandler();
        story = new StoryHandler();
        questHandler = new QuestHandler(scan, story);
        cleanOutput = new CleanOutputHelper();
        leveler = new LevelUpHelper(printer, scan);
        chosenClass = new ClassHandler(leveler);

        commandHandler.initCommands();
        commandHandler.executeCommand("!about");

        cleanOutput.waitClear();

        characterCreation();
        runGame();
    }

    //TODO - Fix interfaces, no need for public
    //TODO - Make classes for all names of potions, stats, items, etc?
    //TODO - JavaDoc on all methods
    //TODO - Use printer instead of sout
    //TODO - Fix helpers generating own instances
    //TODO -    Use ones from main instead, dependency injection
    //TODO - Fix comments around the project
    //TODO -    No need to specify its a method or helper..
    //TODO - Error handling all around.
    //TODO - Add some more of the commands
    //TODO - Add file save/load
    //TODO - User interaction helper - to handle check move/command
    //TODO - Difficulty story starts - Quests and stats
    //TODO - Stat trainers - Quest with specific combat, based on stat
    //TODO - Check quest repeats - unlocks, and difficulty - Helper class?
    //TODO - Character class - Containing other elements?
    //TODO -    Like abilities, classType, items, stats
    //TODO -    Give name, age, eye colour, hair colour, etc??

    /**
     * Gives the user inputs for character creation
     */
    private static void characterCreation() {
        printer.print("Please choose your class");
        printer.print("By writing the name of the class and pressing enter\n");
        printer.printAvailableClasses();
        chosenClass.selectClass(scan.next());

        cleanOutput.clear();
        printer.print("You have chosen the " + chosenClass.getChosenClass().className() + "! Let your journey begin!");
        printer.print("Creating your class...");
        chosenClass.getChosenClass().initClass();

        story.initClassStoryline(chosenClass.getChosenClass());

        cleanOutput.waitClear();
        printer.printClassStats(chosenClass.getChosenClass().stats());
        cleanOutput.waitClear();
        printer.printClassAbilities(chosenClass.getChosenClass().abilities());
        cleanOutput.waitForEnter();
    }

    /**
     * Start the game up and keep it running
     */
    private static void runGame() {
        do {
            cleanOutput.clear();

            printer.print("Make a move");
            printer.print("Here are your options:\n");
            printer.printAvailableQuests(story.getQuests());

            input = scan.next();
            checkInput(input);

        } while (!input.equals("!exit"));
    }

    /**
     * Check for !command and check if move is valid
     *
     * @param input move to check
     */
    private static void checkInput(String input) {
        if (commandHandler.checkForCommand(input)) {
            cleanOutput.clear();
            printer.print(input + " was registered\n");
            commandHandler.executeCommand(input);
            cleanOutput.waitForEnter();
        } else if (input.matches("\\d+")) {
            checkMove(input);
        } else {
            System.out.println("neither move nor command");
        }
    }

    /**
     * If valid move - questHandler.executeQuest() is called and starts the
     * quest.
     *
     * @param move move to check
     */
    private static void checkMove(String move) {
        questHandler.executeQuest(story.getSingleQuest(Integer.parseInt(move)), chosenClass.getChosenClass());
    }

}
