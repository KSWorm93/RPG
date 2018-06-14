/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import character.stats.Stat;
import character.classes.IClass;
import character.classes.Rogue;
import character.classes.Warrior;
import character.classes.Wizard;
import java.util.List;

/**
 *
 * @author kasper
 */
public class ClassHandler {

    private static IClass chosenClass;
    private final LevelUpHelper leveler;

    public ClassHandler(LevelUpHelper leveler) {
        this.leveler = leveler;
    }

    /**
     * Choose which class to use
     *
     * @param chosen
     */
    public void selectClass(String chosen) {
        switch (chosen) {
            case "Warrior":
                chosenClass = new Warrior(leveler);
                break;
            case "Rogue":
                chosenClass = new Rogue();
                break;
            case "Wizard":
                chosenClass = new Wizard();
                break;
            default:
                break;
        }
    }

    /**
     * Get the chosen class
     *
     * @return class
     */
    public IClass getChosenClass() {
        return chosenClass;
    }

    /**
     * Get class' stats
     *
     * @return List<Stat>
     */
    public static List<Stat> getStats() {
        return chosenClass.stats();
    }

}
