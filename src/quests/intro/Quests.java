/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.intro;

import character.stats.StatType;

import java.util.ArrayList;
import java.util.List;

import quests.IQuest;
import quests.encounters.DialogueEncounter;
import quests.encounters.IEncounter;

/**
 * @author kasper
 */
public class Quests implements IQuest {

    private String questName = "Introduction Quest - Quests";
    private StatType type = new StatType();

    @Override
    public String questName() {
        return questName;
    }

    @Override
    public List<IEncounter> questDialogue() {
        List<IEncounter> encounters = new ArrayList<>();

        encounters.add(new DialogueEncounter(
                "You have started the quest: " + questName,
                "This quest-chain will give you some basic " +
                        "\nknowledge of how the game works"));
        encounters.add(new DialogueEncounter(
                "This quest has shown you the basic of the game",
                "That the game works by giving you Quests. " +
                        "\nHave fun :)"));

        return encounters;
    }

    @Override
    public IQuest questInstance() {
        return new Quests();
    }

    @Override
    public List<IQuest> questUnlocks() {
        List<IQuest> quests = new ArrayList<>();
        quests.add(new Stats());
        return quests;
    }

}
