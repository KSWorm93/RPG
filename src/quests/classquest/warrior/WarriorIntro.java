/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.classquest.warrior;

import enemies.IEnemy;
import enemies.SkeletonWarrior;

import java.util.ArrayList;
import java.util.List;

import quests.IQuest;
import quests.encounters.DialogueEncounter;
import quests.encounters.Encounter;
import quests.encounters.IEncounter;

/**
 * @author kasper
 */
public class WarriorIntro implements IQuest {

    private String questName = "Class tutorial - Warrior";

    @Override
    public String questName() {
        return questName;
    }

    @Override
    public List<IEncounter> questDialogue() {
        List<IEncounter> encounters = new ArrayList<>();
        List<IEnemy> enemies = new ArrayList<>();
        enemies.add(new SkeletonWarrior());

        encounters.add(new DialogueEncounter(
                "You have started the quest: " + questName,
                "You will here learn how to defeat enemies"));
        encounters.add(new Encounter(true, enemies));
        encounters.add(new DialogueEncounter(
                "Phew, tough one!",
                "You have vanquished your foe!"));

        return encounters;
    }

    @Override
    public IQuest questInstance() {
        return new WarriorIntro();
    }

}
