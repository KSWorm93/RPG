/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.classes;

import character.abilities.OffensiveAbility;
import character.item.Weapon;
import character.stats.Stat;
import character.abilities.CommonAbility;
import character.abilities.IAbility;
import character.item.IItem;
import character.item.Potion;
import java.util.ArrayList;
import java.util.List;

import character.stats.StatType;
import utils.LevelUpHelper;

/**
 *
 * @author kasper
 */
public class Warrior implements IClass {

    private List<Stat> stats;
    private Weapon mainHand;
    private Weapon offHand;
    private List<IAbility> abilities;
    private List<IItem> inventory;
    private LevelUpHelper leveler;
    private StatType type = new StatType();

    public Warrior(LevelUpHelper leveler) {
        this.leveler = leveler;
    }

    @Override
    public void initClass() {
        initStats();
        initWeapons();
        initAbilities();
        initInventory();
    }

    @Override
    public String className() {
        return "Warrior";
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
    public void onLevelUp(int exp) {
        System.out.println("\nYou have leveled up!");
        //User interaction for stat point increase
        int statInput;
        statInput = leveler.statChooser(stats);
        upgradeStat(stats, statInput, true);

        //Experience points - if more than 100 exp, level up and check again
        exp -= 100;
        stats.get(2).setStatValue(exp);
        checkExp(exp);
    }

    @Override
    public void addReward(int exp, String statPoint, IItem item, IAbility ability) {
        //Experience
        int tempExp = stats.get(2).getStatValue();
        tempExp += exp;
        stats.get(2).setStatValue(tempExp);
        checkExp(stats.get(2).getStatValue());

        //Stats
        if (statPoint != null) {
            int statLoc = stats.indexOf(getSingleStat(statPoint));
            int tempStat = stats.get(statLoc).getStatValue();
            tempStat++;
            stats.get(statLoc).setStatValue(tempStat);
        }

        //Items
        if (item != null) {
            inventory.add(item);
        }

        //Abilities
        if (ability != null) {
            abilities.add(ability);
        }
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
        Stat abilityPoints = new Stat(type.abilityPoints(), 10);
        Stat level = new Stat(type.level(), 1);
        Stat experiencePoints = new Stat(type.experiencePoints(), 0);
        Stat healthPoints = new Stat(type.healthPoints(), 100);
        Stat strength = new Stat(type.strength(), 10);
        Stat agility = new Stat(type.agility(), 6);
        Stat intelligence = new Stat(type.intelligence(), 6);

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
        CommonAbility pass = new CommonAbility("Common", "Pass", 0, 0, 0);
        CommonAbility inventory = new CommonAbility("Common", "Inventory", 0, 0, 0);

        abilities.add(pass);
        abilities.add(inventory);
        abilities.add(slash);
    }

    private void initInventory() {
        inventory = new ArrayList<>();
        Potion back = new Potion("Back", "Back", 0);

        inventory.add(back);
    }

}
