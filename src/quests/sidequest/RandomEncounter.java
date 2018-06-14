/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.sidequest;

import enemies.IEnemy;
import enemies.SkeletonWarrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import quests.IQuest;
import quests.encounters.DialogueEncounter;
import quests.encounters.Encounter;
import quests.encounters.IEncounter;

/**
 * @author kasper
 */
public class RandomEncounter implements IQuest {

    private IEnemy random = getRandomEnemy();
    private String questName = "Random Encounter - REPEATABLE";

    @Override
    public String questName() {
        return questName;
    }

    @Override
    public List<IEncounter> questDialogue() {

        List<IEncounter> encounters = new ArrayList<>();
        List<IEnemy> enemies = new ArrayList<>();
        enemies.add(random);

        encounters.add(new DialogueEncounter(
                "You have started the quest: " + questName,
                "Prepare to face your foes!"));
        encounters.add(new Encounter(true, enemies));
        encounters.add(new DialogueEncounter(
                "Phew, tough one",
                "Quest is done"));

        return encounters;
    }

    private IEnemy getRandomEnemy() {
        ArrayList<IEnemy> randomEnemies = new ArrayList<>();
        randomEnemies.add(new SkeletonWarrior());

        return randomEnemies.get(new Random().nextInt(randomEnemies.size()));
    }

    @Override
    public IQuest questInstance() {
        return new RandomEncounter();
    }

    @Override
    public int experienceReward() {
        return 20;
    }
}
