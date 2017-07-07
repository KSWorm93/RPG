/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import java.util.Scanner;
import quests.classquest.WarriorIntro;
import quests.mainquest.Intro;
import quests.sidequest.RandomEncounter;
import utils.ClassHandler;
import utils.CommandHandler;
import utils.PrintHelper;
import utils.QuestHandler;
import utils.StoryHandler;

/**
 *
 * @author kasper
 */
public class Main {

    private static PrintHelper printer;
    private static CommandHandler commandHandler;
    private static Scanner scan;
    private static String input;
    private static QuestHandler questHandler;
    private static ClassHandler myClass;
    private static StoryHandler story;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scan = new Scanner(System.in, "UTF-8");
        printer = new PrintHelper();
        commandHandler = new CommandHandler();
        story = new StoryHandler();
        questHandler = new QuestHandler(scan, story);
        myClass = new ClassHandler();

        commandHandler.initCommands();
        commandHandler.executeCommand("!about");

        System.out.println("\nPlease choose your class");
        printer.printAvailableClasses();
        myClass.selectClass(scan.next());

        System.out.println("You have choosen the " + myClass.getChosenClass().className() + "! Let your journey begin!");
        System.out.println("Creating your class...");
        myClass.getChosenClass().initClass();
        
        //TODO - move quests adding out of main
        story.addQuest(new Intro());
        story.addQuest(new WarriorIntro());
        story.addQuest(new RandomEncounter());

        printer.printClassStats(myClass.getChosenClass().stats());
        printer.printClassAbilities(myClass.getChosenClass().abilities());

        //Keep running game till exit command is given
        do {
            System.out.println("\nMake a move");
            System.out.println("Here are your options:");
            printer.printAvailableQuests(story.getQuests());
            input = scan.next();
            checkInput(input);

        } while (!input.equals("!exit"));

    }

    private static void checkInput(String input) {
        if (commandHandler.checkForCommand(input)) {
            commandHandler.executeCommand(input);
        } else if (input.matches("\\d+")) {
            checkMove(input);
        } else {
            System.out.println("neither move nor command");
        }
    }

    private static void checkMove(String move) {
        questHandler.executeQuest(story.getSingleQuest(Integer.parseInt(move)), myClass.getChosenClass());
    }

}
