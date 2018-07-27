package gameEngine;

import java.util.Scanner;

import utils.*;

public class GameEngine {
    private static Scanner scan;
    private static PrintHelper printHelper;
    private static CommandHandler commandHandler;
    private static StoryHandler storyHandler;
    private static CleanOutputHelper cleanOutput;
    private static CombatHandler combatHandler;
    private static LevelUpHelper levelUpHelper;
    private static ClassHandler classHandler;
    private static QuestHandler questHandler;

    public void startNewGame() {
        scan = new Scanner(System.in, "UTF-8");
        printHelper = new PrintHelper();
        commandHandler = new CommandHandler();
        storyHandler = new StoryHandler();
        cleanOutput = new CleanOutputHelper(scan, commandHandler, printHelper);
        combatHandler = new CombatHandler(scan, printHelper, cleanOutput, commandHandler);
        levelUpHelper = new LevelUpHelper(printHelper, scan);
        classHandler = new ClassHandler(levelUpHelper);
        questHandler = new QuestHandler(storyHandler, printHelper, cleanOutput, combatHandler);


        commandHandler.initCommands();
        commandHandler.executeCommand("!about");

        cleanOutput.waitClear();

        characterCreation();
        runGame();
    }

    //TODO - Make classes for all names of potions, stats, items, etc?
    //TODO - JavaDoc on all methods
    //TODO - Use printHelper instead of sout
    //TODO - Fix helpers generating own instances
    //TODO -    Use ones from main instead, dependency injection
    //TODO - Fix comments around the project
    //TODO -    No need to specify its a method or helper..
    //TODO - Error handling all around.
    //TODO - Add some more of the commands
    //TODO - Add file save/load
    //TODO - User interaction helper - to handle check move/command
    //TODO - Difficulty storyHandler starts - Quests and stats
    //TODO - Stat trainers - Quest with specific combat, based on stat
    //TODO - Check quest repeats - unlocks, and difficulty - Helper class?
    //TODO - Character class - Containing other elements?
    //TODO -    Like abilities, classType, items, stats
    //TODO -    Give name, age, eye colour, hair colour, etc??
    //TODO - Add professions - crafting, gather, fish, sculpture, blacksmith etc.
    //TODO - Move 'Handlers* to game gameEngine folder
    //TODO - make 'Helpers' independent
    //TODO -    Pull handlers/helpers to seperate projects, and load via interfaces
    //TODO - main quest limits, 10 quest to unlock
    //TODO - Make a setting menu, save as config file
    //TODO - Refactor quests to use csv files/arrays other instead of classes?

    /**
     * Gives the user inputs for character creation
     */
    private static void characterCreation() {
        printHelper.print("Please choose your class");
        printHelper.print("By writing the name of the class and pressing enter\n");
        printHelper.printAvailableClasses();
        classHandler.selectClass(scan.next());

        cleanOutput.clear();
        printHelper.print("You have chosen the " + classHandler.getChosenClass().className() + "! Let your journey begin!");
        printHelper.print("Creating your class...");
        classHandler.getChosenClass().initClass();

        storyHandler.initClassStoryline(classHandler.getChosenClass());

        cleanOutput.waitClear();
        printHelper.printClassStats(classHandler.getChosenClass().stats());
        cleanOutput.waitClear();
        printHelper.printClassAbilities(classHandler.getChosenClass().abilities());
        cleanOutput.waitForEnter();
    }

    /**
     * Start the game up and keep it running
     */
    private static void runGame() {
        String input;
        do {
            cleanOutput.clear();

            printHelper.print("Make a move");
            printHelper.print("Here are your options:\n");
            printHelper.printAvailableQuests(storyHandler.getQuests());

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
            printHelper.print(input + " was registered\n");
            commandHandler.executeCommand(input);
            cleanOutput.waitForEnter();
        } else if (input.matches("\\d+")) {
            checkMove(input);
        } else {
            printHelper.print(input + " was neither a move nor a command");
        }
    }

    /**
     * If valid move - questHandler.executeQuest() is called and starts the
     * quest.
     *
     * @param move move to check
     */
    private static void checkMove(String move) {
        questHandler.executeQuest(storyHandler.getSingleQuest(Integer.parseInt(move)), classHandler.getChosenClass());
    }

}
