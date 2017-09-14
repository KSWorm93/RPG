/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import character.classes.IClass;
import enemies.IEnemy;
import java.util.Scanner;

/**
 *
 * @author kasper
 */
public class CombatHandler {

    private final Scanner scan;
    private final PrintHelper printer = new PrintHelper();
    private final CommandHandler commander = new CommandHandler();
    private final CleanOutputHelper cleaner = new CleanOutputHelper();
    private final String hp = "Health Points";

    public CombatHandler(Scanner scan) {
        this.scan = scan;
    }

    /**
     * Starts the combat sequence against a chosen enemy
     *
     * @param yourClass your class - that is going to fight
     * @param enemy the enemy - that you are fighting against
     */
    public void startCombat(IClass yourClass, IEnemy enemy) {
        int tempMyHP;

        do {
            cleaner.waitClear();
            printHealthPoints(yourClass, enemy);
            tempMyHP = yourClass.stats().get(3).getStatValue();
            enemyTurn(enemy);
            yourClass.getSingleStat(hp).setStatValue(tempMyHP - 2);
            cleaner.waitForEnter();
            yourTurn(yourClass, enemy, tempMyHP, yourClass.abilityPoints(), "");

        } while (!(tempMyHP <= 0 || enemy.healthPoints() <= 0));
    }

    private void enemyTurn(IEnemy enemy) {
        System.out.println("\nEnemy struck first..");
        System.out.println("\nEnemy harmed you for: " + enemy.hitYou());
    }

    /**
     * Performs the users action until ability points are run out
     *
     * @param yourClass
     * @param enemy
     * @param tempMyHP your current health points
     * @param resetActionPoint your current ability points
     */
    private void yourTurn(IClass yourClass, IEnemy enemy, int tempMyHP, int resetActionPoint, String msg) {
        String input;

        if (resetActionPoint > 0) {
            cleaner.clear();
            printHealthPoints(yourClass, enemy);
            System.out.println("\nYour turn");
            printer.printCombatOptions(yourClass.abilities(), yourClass.inventory());
            System.out.println("You have " + resetActionPoint + " Ability Points remaining for this turn.");
            System.out.println(msg);
            input = scan.next(); // to stop and make user input

            if (commander.checkForCommand(String.valueOf(input))) {
                commander.executeCommand(input);
            }

            checkAP(yourClass, Integer.parseInt(input), resetActionPoint, enemy, tempMyHP);
            resetActionPoint -= checkAbility(yourClass, Integer.parseInt(input), enemy, tempMyHP, resetActionPoint);

            if (enemy.healthPoints() <= 0) {
                return;
            }
            yourTurn(yourClass, enemy, tempMyHP, resetActionPoint, "");
        }
    }

    private void printHealthPoints(IClass yourClass, IEnemy enemy) {
        System.out.println("Your Health Points are: " + yourClass.getSingleStat(hp).getStatValue());
        System.out.println("Enemy Health Points are: " + enemy.healthPoints());
    }

    /**
     * Method to check ability type, and act accordingly
     *
     * @param yourClass
     * @param input input to get ability
     * @param enemy enemy to hit if offensive ability
     * @param tempMyHP your current health points
     */
    private int checkAbility(IClass yourClass, int input, IEnemy enemy, int tempMyHP, int resetActionPoints) {
        switch (yourClass.abilities().get(input).getType()) {
            case "Offensive":
                enemy.hit(yourClass.abilities().get(input).getValue());
                return yourClass.abilities().get(input).getCost();
            case "Defensive":
                yourClass.getSingleStat(hp).setStatValue(tempMyHP + yourClass.abilities().get(input).getValue());
                checkHP(yourClass);
                return yourClass.abilities().get(input).getCost();
            default:
                if (yourClass.abilities().get(input).getName().equals("Inventory")) {
                    printer.printInventory(yourClass.inventory());
                    return inventorySelector(yourClass, tempMyHP, enemy, resetActionPoints);
                } else {
                    return yourClass.getSingleStat("Ability Points").getStatValue();
                }
        }
    }

    /**
     * Choose which item in inventory to use. Checks type of item and act
     * accordingly, returning the cost and adding the effects
     *
     * @param yourClass
     * @param tempMyHP
     * @param enemy
     * @param resetActionPoints
     * @throws NumberFormatException
     */
    private int inventorySelector(IClass yourClass, int tempMyHP, IEnemy enemy, int resetActionPoints) throws NumberFormatException {
        int item = Integer.parseInt(scan.next());
        if (yourClass.inventory().get(item).type().contains("Healing")) {
            yourClass.getSingleStat(hp).setStatValue(tempMyHP + yourClass.inventory().get(item).cost());
            checkHP(yourClass);
            return 4;
        } else if (yourClass.inventory().get(item).type().contains("Back")) {
            return 0;
        } else {
            return 4;
        }
    }

    /**
     * Method to check whether max hp is reached, and if it is, set it to max hp
     *
     * @param yourClass yourclass to get hp stat
     */
    private void checkHP(IClass yourClass) {
        if (yourClass.getSingleStat(hp).getStatValue() >= 100) {
            yourClass.getSingleStat(hp).setStatValue(100);
        }
    }

    /**
     * Method to check if user have enough ability points to perform the action
     * calls yourTurn() if not
     *
     * @param yourClass
     * @param input input to choose action
     * @param resetActionPoint your current ability points
     * @param enemy enemy you are facing
     * @param tempMyHP your current health points
     */
    private void checkAP(IClass yourClass, int input, int resetActionPoint, IEnemy enemy, int tempMyHP) {
        if (yourClass.abilities().get(input).getCost() > resetActionPoint) {
            String msg = "\nYou dont have enough Ability Points to do this action\nTry something else";
            yourTurn(yourClass, enemy, tempMyHP, resetActionPoint, msg);
        }
    }

}
