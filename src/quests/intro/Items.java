/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.intro;

import character.item.IItem;
import character.item.Potion;
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
public class Items implements IQuest {

    private String questName = "Introduction Quest - Items";

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
                        "\nknowledge of how items works."));
        encounters.add(new DialogueEncounter(
                "Items comes in many different ways.",
                "Some to hurt your enemies, some to defend yourself."));
        encounters.add(new DialogueEncounter(
                "Defensive items to buff or heal yourself, or allies.",
                "Offensive items to debuff or damage your opponent."));
        encounters.add(new DialogueEncounter(
                "Each item is equipped on your character and buff your stats.",
                "Remaining items will be stored in your inventory."));

        return encounters;
    }

    @Override
    public IQuest questInstance() {
        return new Quests();
    }

    @Override
    public List<IQuest> questUnlocks() {
        return null;
    }

    @Override
    public IItem itemReward() {
        return new Potion("Tiny Healing Potion", "Healing Potion", 10);
    }

}
