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
import quests.moves.IMove;

/**
 *
 * @author kasper
 */
public interface IQuest {
    public String questName();
    public List<IEnemy> enemies();
    public List<IMove> questMoves();
    public List<String> questDialogue();
    public IQuest questInstance();
    public List<IQuest> questUnlocks();
    default public IItem itemReward(){
        return null;
    }
    default public IAbility abilityReward(){
        return null;
    }
    default public String statReward(){
        return null;
    }
}
