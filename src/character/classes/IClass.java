/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.classes;

import character.item.Weapon;
import character.Stat;
import character.abilities.IAbility;
import character.item.IItem;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kasper
 */
public interface IClass {

    public void initClass();

    public String className(); //Name of the class

    public List<Stat> stats(); //List of stats the character has

    public List<IAbility> abilities(); //List of abilities the character has

    public Set<IItem> inventory(); //All the items

    public Weapon mainHand(); //Mainhand weapon

    public Weapon offHand(); //Offhand weapon

    public int abilityPoints(); //Points to spend on moves during combat

    public void onLevelUp(int exp); //Decide stat upgrade

    public void addReward(int exp, String statPoint, IItem item, IAbility ability);

    public Stat getSingleStat(String nameOfStat);

    /**
     * Check if exp stat is greater than 100 then call onLevelUp() if it is
     *
     * @param exp experience stat
     */
    default public void checkExp(int exp) {
        if (exp >= 100) {
            onLevelUp(exp);
        }
    }
;
}
