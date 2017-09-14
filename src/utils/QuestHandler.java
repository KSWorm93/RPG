/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import character.classes.IClass;
import enemies.IEnemy;
import java.util.Scanner;
import quests.IQuest;
import quests.moves.IMove;

/**
 *
 * @author kasper
 */
public class QuestHandler {

    private final Scanner scan;
    private final CommandHandler commander = new CommandHandler();
    private CombatHandler combatter;
    private final StoryHandler story;
    private final CleanOutputHelper cleaner = new CleanOutputHelper();

    public QuestHandler(Scanner scan, StoryHandler story) {
        this.scan = scan;
        this.story = story;
    }

    /**
     * Starts the quest
     *
     * @param quest quest to start
     * @param myClass user class to do the quest
     */
    public void executeQuest(IQuest quest, IClass myClass) {
        quest(quest, myClass);
    }

    /**
     * Actual method that execues the quest
     *
     * @param quest
     * @param myClass
     */
    private void quest(IQuest quest, IClass myClass) {
        int experience = 0;
        int index = 0;

        for (String dialogue : quest.questDialogue()) {
            System.out.println(dialogue);
            IMove move = quest.questMoves().get(index);
            if (move.encounter()) {
                combatMove(quest, index, myClass);
                experience += 5;
            } else {
                notCombatMove(move);
            }
            experience += 10;
            index++;
        }
        questCompleted(quest);
        myClass.addReward(experience, quest.statReward(), quest.itemReward(), quest.abilityReward());
        story.removeQuest(quest);
        if (quest.questUnlocks() != null) {
            story.addQuests(quest.questUnlocks());
        }

    }

    /**
     * Handles the combat part of a quest
     *
     * @param quest
     * @param index enemy based on how far in quest you are
     * @param myClass
     */
    private void combatMove(IQuest quest, int index, IClass myClass) {
        combatter = new CombatHandler(scan);

        IEnemy enemy = quest.enemies().get(index);
        System.out.println("\nThere is an enemy blocking your way"
                + "\nDefeat it to proceed");
        combatter.startCombat(myClass, enemy);
    }

    /**
     * If quest move is not a combat scenario
     *
     * @param move
     */
    private void notCombatMove(IMove move) {
        cleaner.waitClear();
        String input;
        switch (move.numberOfMoves()) {
            case 1:
                singleOption();
                input = scan.next();
                checkMove(input, move);
                break;
            case 2:
                twoOptions();
                input = scan.next();
                checkMove(input, move);
                break;
            default:
                threeOptions();
                input = scan.next();
                checkMove(input, move);
                break;
        }
    }

    /**
     * Executed when the quest is completed Prints quest name
     *
     * @param quest
     */
    private void questCompleted(IQuest quest) {
        System.out.println("\nYou have succesfully completed: "
                + quest.questName()
                + "\nCongratulations. Rewards have been added to you");
    }

    /**
     * Checks whether move is a !command, or print user choice
     *
     * @param path
     * @param returnMove
     */
    private void checkMove(String path, IMove returnMove) {
        if (commander.checkForCommand(path)) {
            commander.executeCommand(path);
            notCombatMove(returnMove);
        } else {
            whatUserDid(path);
        }
    }

    /**
     * Prints user choice
     *
     * @param path
     * @throws NumberFormatException
     */
    private void whatUserDid(String path) throws NumberFormatException {
        switch (Integer.parseInt(path)) {
            case 1:
                System.out.println("\nYou have chosen option 1");
                break;
            case 2:
                System.out.println("\nYou have chosen option 2");
                break;
            default:
                System.out.println("\nYou have chosen option 3");
                break;
        }
    }

    private void singleOption() {
        System.out.println("\nYou have the option to move forward - press 1");
    }

    private void twoOptions() {
        System.out.println("\nYou have 2 options");
        System.out.println("press 1 to - Move forward");
        System.out.println("press 2 to - Turn left");
    }

    private void threeOptions() {
        System.out.println("\nYou have 3 options");
        System.out.println("press 1 to - Move forward");
        System.out.println("press 2 to - Turn left");
        System.out.println("press 3 to - Turn right");
    }

}
