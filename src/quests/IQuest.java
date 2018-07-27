/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests;

import character.abilities.IAbility;
import character.item.IItem;
import enemies.IEnemy;

import java.util.List;

import quests.encounters.IEncounter;

/**
 * @author kasper
 */
public interface IQuest {
    String questName();

    List<IEncounter> questDialogue();
    IQuest questInstance();
    default List<IQuest> questUnlocks() {
        return null;
    }
    //TODO - Make rewards LIST of rewards
    //TODO   - Multiple rewards each quest
    default IItem itemReward() {
        return null;
    }
    default IAbility abilityReward() {
        return null;
    }
    default String statReward() {
        return null;
    }
    default int experienceReward() {
        return 10;
    }
}
