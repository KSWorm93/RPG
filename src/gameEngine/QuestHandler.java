/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameEngine;

import character.classes.IClass;
import enemies.IEnemy;

import java.util.List;

import quests.IQuest;
import quests.encounters.IEncounter;
import utils.CleanOutputHelper;
import utils.PrintHelper;

/**
 * @author kasper
 */
public class QuestHandler {

    private final StoryHandler story;
    private final CleanOutputHelper cleaner;
    private final PrintHelper printer;
    private final CombatHandler combatant;

    public QuestHandler(StoryHandler story, PrintHelper printer, CleanOutputHelper cleaner, CombatHandler combatant) {
        this.story = story;
        this.printer = printer;
        this.cleaner = cleaner;
        this.combatant = combatant;
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
                printer.print(encounter.beforeDialogue());
                printer.print(encounter.afterDialogue());
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
        //TODO - Move those dialogue options to combatant?
        for (IEnemy enemy : enemies) {
            printer.print(encounter.beforeDialogue());
            printer.print("I am the mighty " + enemy.name());
            //TODO - Check startCombat() for matching dialogues
            combatant.startCombat(chosenClass, enemy, encounter.encounterSwearing());
            printer.print(encounter.afterDialogue());
        }
    }
}
