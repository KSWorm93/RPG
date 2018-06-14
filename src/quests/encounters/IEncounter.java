/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.encounters;

import enemies.IEnemy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kasper
 */
public interface IEncounter {
    default boolean encounter() {
        return false;
    }

    //TODO - Add more swearing
    default List<String> encounterSwearing() {
        return new ArrayList<String>() {
            {
                add("Dammit!");
                add("Curse you!");
                add("Die!");
            }
        };
    }

    default List<IEnemy> enemies() {
        return null;
    }

    default String beforeDialogue() {
        return "You can't defeat me!!";
    }

    default String afterDialogue() {
        return "How.. You have defeated me!";
    }
}
