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
        cleanOutput = new CleanOutputHelper(scan, printHelper);
        combatHandler = new CombatHandler(scan, printHelper, cleanOutput, commandHandler);
        levelUpHelper = new LevelUpHelper(printHelper, scan);
        classHandler = new ClassHandler(levelUpHelper);
        questHandler = new QuestHandler(storyHandler, printHelper, cleanOutput, combatHandler, commandHandler);


        commandHandler.initCommands();
        commandHandler.executeCommand("!about");

        cleanOutput.waitClear(commandHandler);

        characterCreation();
        runGame();
    }

    //TODO - Feat - Make classes for all names of potions, stats, items, etc?
    //TODO - Fix  - commands getting overwritten
    //TODO - Docs - JavaDoc on all methods
    //TODO - Feat - Use printHelper instead of sout
    //TODO - Fix  - helpers generating own instances
    //TODO -    Use ones from main instead, dependency injection
    //TODO - Fix  - comments around the project
    //TODO -    No need to specify its a method or helper..
    //TODO - Feat - Error handling all around.
    //TODO - Feat - Add some more of the commands
    //TODO - Feat - Add file save/load
    //TODO - Feat - User interaction helper - to handle check move/command
    //TODO - Feat - Difficulty helper class
    //TODO - Feat - storyHandler starts - Quests and stats
    //TODO - Feat - Stat trainers - Quest with specific combat, based on stat
    //TODO - Feat - Check quest repeats - unlocks
    //TODO - Feat - Character class - Containing other elements?
    //TODO -    Like abilities, classType, items, stats
    //TODO -    Give name, age, eye colour, hair colour, etc??
    //TODO - Feat - Professions - crafting, gather, fish, sculpture, blacksmith etc.
    //TODO - Fix  - make 'Helpers' independent
    //TODO -    Pull handlers/helpers to seperate projects, and load via interfaces
    //TODO - Feat - main quest limits, 10 quest to unlock
    //TODO - Feat - Make a setting menu, save as config file
    //TODO - Fix  - Refactor quests to use csv files/arrays other instead of classes?

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

        cleanOutput.waitClear(commandHandler);
        printHelper.printClassStats(classHandler.getChosenClass().stats());
        cleanOutput.waitClear(commandHandler);
        printHelper.printClassAbilities(classHandler.getChosenClass().abilities());
        cleanOutput.waitForEnter(commandHandler);
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
            cleanOutput.waitForEnter(commandHandler);
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
