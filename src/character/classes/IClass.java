/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.classes;

import character.item.Weapon;
import character.stats.Stat;
import character.abilities.IAbility;
import character.item.IItem;
import java.util.List;

/**
 *
 * @author kasper
 */
public interface IClass {

    //TODO - Limit inventory space when adding rewards

    void initClass();
    String className(); //Name of the class
    List<Stat> stats(); //List of stats the character has
    List<IAbility> abilities(); //List of abilities the character has
    List<IItem> inventory(); //All the items
    Weapon mainHand(); //Mainhand weapon
    Weapon offHand(); //Offhand weapon
    int abilityPoints(); //Points to spend on encounters during combat
    void onLevelUp(int exp); //Decide stat upgrade
    void addReward(int exp, String statPoint, IItem item, IAbility ability);
    Stat getSingleStat(String nameOfStat);

    /**
     * Check if exp stat is greater than 100 then call onLevelUp() if it is
     *
     * @param exp experience stat
     */
    default void checkExp(int exp) {
        if (exp >= 100) {
            onLevelUp(exp);
        }
    }
;
}
