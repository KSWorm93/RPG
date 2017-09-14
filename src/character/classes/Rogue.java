/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.classes;

import character.item.Weapon;
import character.Stat;
import character.abilities.CommonAbility;
import character.abilities.DefensiveAbility;
import character.abilities.IAbility;
import character.abilities.OffensiveAbility;
import character.item.IItem;
import character.item.Potion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kasper
 */
public class Rogue implements IClass {

    private List<Stat> stats;
    private Weapon mainHand;
    private Weapon offHand;
    private List<IAbility> abilities;
    private List<IItem> inventory;

    @Override
    public String className() {
        return "Rogue";
    }

    @Override
    public List<Stat> stats() {
        return stats;
    }

    @Override
    public List<IAbility> abilities() {
        return abilities;
    }

    @Override
    public List<IItem> inventory() {
        return inventory;
    }

    @Override
    public Weapon mainHand() {
        return mainHand;
    }

    @Override
    public Weapon offHand() {
        return offHand;
    }

    @Override
    public int abilityPoints() {
        return stats.get(0).getStatValue();
    }

    @Override
    public void initClass() {
        initStats();
        initWeapons();
        initAbilities();
        initInventory();
    }

    @Override
    public void onLevelUp(int exp) {
        //TODO - get user to interact and choose which stat to use
        System.out.println("\nYou have leveled up, you will now upgrade agility");
        upgradeStat(stats, 5, true);
        stats.get(2).setStatValue(0);
    }

    @Override
    public void addReward(int exp, String statPoint, IItem item, IAbility ability) {
        int temp = stats.get(2).getStatValue();
        temp += exp;
        stats.get(2).setStatValue(temp);

        checkExp(stats.get(2).getStatValue());
    }

    @Override
    public Stat getSingleStat(String nameOfStat) {
        for (Stat stat : stats) {
            if (stat.getStatName().equals(nameOfStat)) {
                return stat;
            }
        }
        return null;
    }
    
    /**
     * Upgrade single stat
     *
     * @param stats List of stats
     * @param statToBeUpgraded single stat to be upgraded
     * @param increase boolean value, true if increase, false if decrease
     */
    private void upgradeStat(List<Stat> stats, int statToBeUpgraded, boolean increase) {
        Stat tempStat = new Stat("", 0);
        int newStat;
        if (increase) {
            tempStat.setStatName(stats.get(statToBeUpgraded).getStatName());
            tempStat.setStatValue(stats.get(statToBeUpgraded).getStatValue() + 1);

            stats.set(statToBeUpgraded, tempStat);
        } else {
            tempStat.setStatName(stats.get(statToBeUpgraded).getStatName());
            tempStat.setStatValue(stats.get(statToBeUpgraded).getStatValue() - 1);

            stats.set(statToBeUpgraded, tempStat);
        }

    }
    
    /**
     * initialize standard stats
     */
    private void initStats() {
        stats = new ArrayList<>();
        Stat abilityPoints = new Stat("Ability Points", 10);
        Stat level = new Stat("Level", 1);
        Stat experiencePoints = new Stat("Experience Points", 0);
        Stat healthPoints = new Stat("Health Points", 100);
        Stat strength = new Stat("Strength", 6);
        Stat agility = new Stat("Agility", 10);
        Stat intelligence = new Stat("Intelligence", 6);

        stats.add(abilityPoints);
        stats.add(level);
        stats.add(experiencePoints);
        stats.add(healthPoints);
        stats.add(strength);
        stats.add(agility);
        stats.add(intelligence);
    }

    /**
     * Start weapons
     */
    private void initWeapons() {
        mainHand = new Weapon("Stick", "Club", "Common", 3, 1);
        offHand = new Weapon("Thick Branch", "Shield", "Common", 1, 3);
    }

    private void initAbilities() {
        abilities = new ArrayList<>();
        OffensiveAbility slash = new OffensiveAbility("Offensive", "Slash", 2, 4, 1);
        DefensiveAbility firstAid = new DefensiveAbility("Defensive", "First Aid", 4, 10, 1);
        CommonAbility pass = new CommonAbility("Common", "Pass", 0, 0, 0);

        abilities.add(pass);
        abilities.add(slash);
        abilities.add(firstAid);
    }

    private void initInventory() {
        inventory = new ArrayList<>();
        Potion tinyHealingPotion = new Potion("Tiny Healing Potion", "Healing Potion", 10);

        inventory.add(tinyHealingPotion);
    }

}
