/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import character.classes.IClass;
import enemies.IEnemy;

import java.util.List;
import java.util.Scanner;

import quests.IQuest;
import quests.encounters.IEncounter;

/**
 * @author kasper
 */
public class QuestHandler {

    private final Scanner scan;
    private final StoryHandler story;
    private final CleanOutputHelper cleaner = new CleanOutputHelper();

    public QuestHandler(Scanner scan, StoryHandler story) {
        this.scan = scan;
        this.story = story;
    }

    /**
     * Starts the quest
     *
     * @param quest   quest to start
     * @param chosenClass user class to do the quest
     */
    public void executeQuest(IQuest quest, IClass chosenClass) {
        quest(quest, chosenClass);
    }

    /**
     * Actual method that executes the quest
     *
     * @param quest       currently active quest
     * @param chosenClass player selected class
     */
    private void quest(IQuest quest, IClass chosenClass) {
        cleaner.clear();

        for (IEncounter encounter : quest.questDialogue()) {
            if (encounter.encounter()) {
                combatMove(encounter.enemies(), encounter, chosenClass);
            } else {
                System.out.println(encounter.beforeDialogue());
                System.out.println(encounter.afterDialogue());
            }
            cleaner.waitClear();
        }
        chosenClass.addReward(quest.experienceReward(), quest.statReward(), quest.itemReward(), quest.abilityReward());
        story.removeQuest(quest);
        if (quest.questUnlocks() != null) {
            story.addQuests(quest.questUnlocks());
        }
    }

    /**
     * Handles the combat part of a quest
     *
     * @param enemies     based on how far in quest you are
     * @param chosenClass player selected class
     */
    private void combatMove(List<IEnemy> enemies, IEncounter encounter, IClass chosenClass) {
        CombatHandler combatant = new CombatHandler(scan);

        //TODO - Move those dialogue options to combatant?
        for (IEnemy enemy : enemies) {
            System.out.println(encounter.beforeDialogue());
            System.out.println("I am the mighty " + enemy.name());
            //TODO - Check startCombat() for matching dialogues
            combatant.startCombat(chosenClass, enemy, encounter.encounterSwearing());
            System.out.println(encounter.afterDialogue());
        }
    }
}
