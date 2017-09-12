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

    public void executeQuest(IQuest quest, IClass myClass) {
        quest(quest, myClass);
    }

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
        myClass.addReward(experience, null, null, null);
        story.removeQuest(quest);
        story.addQuests(quest.questUnlocks());
        
    }

    private void combatMove(IQuest quest, int index, IClass myClass) {
        combatter = new CombatHandler(scan);

        IEnemy enemy = quest.enemies().get(index);
        System.out.println("\nThere is an enemy blocking your way"
                + "\nDefeat it to proceed");
        combatter.startCombat(myClass, enemy);
    }

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

    private void questCompleted(IQuest quest) {
        System.out.println("\nYou have succesfully completed: "
                + quest.questName()
                + "\nCongratulations. Rewards have been added to you");
    }

    private void checkMove(String path, IMove returnMove) {
        if (commander.checkForCommand(path)) {
            commander.executeCommand(path);
            notCombatMove(returnMove);
        } else {
            whatUserDid(path);
        }
    }

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
