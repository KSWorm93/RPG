/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.intro;

import character.abilities.DefensiveAbility;
import character.abilities.IAbility;

import java.util.ArrayList;
import java.util.List;

import quests.IQuest;
import quests.encounters.DialogueEncounter;
import quests.encounters.IEncounter;

/**
 * @author kasper
 */
public class Abilities implements IQuest {

    private String questName = "Introduction Quest - Abilities";

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
                        "\nknowledge of how abilities works."));
        encounters.add(new DialogueEncounter(
                "Abilities comes in many different ways.",
                "Some to hurt your enemies, some to defend yourself."));
        encounters.add(new DialogueEncounter(
                "Defensive to buff or heal yourself, or allies.",
                "Offensive to debuff or damage your opponent."));
        encounters.add(new DialogueEncounter(
                "Each ability uses a portion of your ability power.",
                "When you run out of ability power, " +
                        "\nyou will be unable to use any ability"));

        return encounters;
    }

    @Override
    public IQuest questInstance() {
        return new Quests();
    }

    @Override
    public List<IQuest> questUnlocks() {
        List<IQuest> quests = new ArrayList<>();
        quests.add(new Items());
        return quests;
    }

    @Override
    public IAbility abilityReward() {
        return new DefensiveAbility("Defensive", "First Aid", 4, 10, 1);
    }

}
