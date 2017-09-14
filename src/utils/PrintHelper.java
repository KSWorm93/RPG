/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import character.Stat;
import character.abilities.IAbility;
import character.item.IItem;
import commands.ICommand;
import java.util.List;
import quests.IQuest;

/**
 *
 * @author kasper
 */
public class PrintHelper {

    /**
     * Helper method to print users stats out.
     *
     * @param stats list of stats
     */
    public void printClassStats(List<Stat> stats) {
        System.out.println("\nThese are the stats for your class.");
        for (Stat stat : stats) {
            System.out.println(stat.getStatName() + ": " + stat.getStatValue());
        }
    }

    /**
     * Helper method to print users stats out. contains index
     *
     * @param stats list of stats
     */
    public void printClassStatsWithNums(List<Stat> stats) {
        System.out.println("\nThese are the stats for your class, with their current value.");
        int index = 0;
        for (Stat stat : stats) {
            System.out.println(index++ + ": " + stat.getStatName() + ": " + stat.getStatValue());
        }
    }

    /**
     * Helper method to print users abilities out.
     *
     * @param abilities list of abilities
     */
    public void printClassAbilities(List<IAbility> abilities) {
        System.out.println("\nThese are all your available abilities");
        for (IAbility ability : abilities) {
            System.out.println(ability.getName() + " Type: " + ability.getType() + " Cost: " + ability.getCost());
        }
    }

    /**
     * Nicely print combat options
     *
     * @param abilities users abilities
     * @param inventory users inventory
     */
    public void printCombatOptions(List<IAbility> abilities, List<IItem> inventory) {
        System.out.println("\nThese are your options");
        int index = 0;
        for (IAbility ability : abilities) {
            System.out.println(index++ + ": " + ability.getName() + " Type: " + ability.getType() + " Cost: " + ability.getCost());
        }
    }

    /**
     * Prints the users inventory
     *
     * @param inventory
     */
    public void printInventory(List<IItem> inventory) {
        System.out.println("\nThese are your options");
        int index = 0;
        for (IItem item : inventory) {
            System.out.println(index++ + ": " + item.name() + " Type: " + item.type() + " Cost: " + item.cost());
        }
    }

    /**
     * Prints the !commands
     *
     * @param commands
     */
    public void printAvailableCommands(List<ICommand> commands) {
        System.out.println("\nThese are the avaiblable commands");
        for (ICommand command : commands) {
            System.out.println(command.commandName());
        }
    }

    /**
     * Prints all available classes during statup
     */
    public void printAvailableClasses() {
        System.out.println("You have the choice of choosing the following classes:");
        System.out.println("The mighty Warrior! - To choose type \"Warrior\"");
        System.out.println("The cunning Rogue! - To choose type \"Rogue\"");
        System.out.println("The wise Wizard! - To choose type \"Wizard\" - not working");
    }

    /**
     * Prints available quests
     *
     * @param quests
     */
    public void printAvailableQuests(List<IQuest> quests) {
        System.out.println("\nThese are your available Quests");
        int index = 0;
        for (IQuest quest : quests) {
            System.out.println(index + ": " + quest.questName());
            index++;
        }
        System.out.println("Write the given number to start the quest.");
    }

}
