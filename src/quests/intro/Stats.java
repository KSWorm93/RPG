/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.intro;

import enemies.IEnemy;
import enemies.SkeletonWarrior;

import java.util.ArrayList;
import java.util.List;

import quests.IQuest;
import quests.encounters.DialogueEncounter;
import quests.encounters.IEncounter;

/**
 * @author kasper
 */
public class Stats implements IQuest {

    private String questName = "Introduction Quest - Stats";

    @Override
    public String questName() {
        return questName;
    }

    @Override
    public List<IEncounter> questDialogue() {
        List<IEncounter> encounters = new ArrayList<>();

        encounters.add(new DialogueEncounter(
                "You have started the quest: " + questName,
                "This quest will give you some " +
                        "\nknowledge of how stats works."));
        encounters.add(new DialogueEncounter(
                "Stats comes in many different ways.",
                "Some to increase your damage on enemies, some to defend yourself."));
        encounters.add(new DialogueEncounter(
                "Strength - Is the most direct power upgrade.",
                "It will increase all your physical damage."));
        encounters.add(new DialogueEncounter(
                "Agility - Is a defensive stat.",
                "It increases your chances to dodge incoming blows."));
        encounters.add(new DialogueEncounter(
                "Intelligence - Is a magical stat.",
                "It will increase all your magical damage."));
        encounters.add(new DialogueEncounter(
                "Health Points - Is a defensive stat.",
                "It determines whether you live or die. If it reaches 0, it's game over!."));
        encounters.add(new DialogueEncounter(
                "Ability Points - Is a core stat.",
                "It increases the amount of abilities you can use each turn."));
        encounters.add(new DialogueEncounter(
                "Experience Points - Is a core stat.",
                "It is used to track your level progress."));
        encounters.add(new DialogueEncounter(
                "Level - is a core stat.",
                "It's used to give a value on how powerful you are."));

        return encounters;
    }

    @Override
    public IQuest questInstance() {
        return new Quests();
    }

    @Override
    public List<IQuest> questUnlocks() {
        List<IQuest> quests = new ArrayList<>();
        quests.add(new Abilities());
        return quests;
    }
}
