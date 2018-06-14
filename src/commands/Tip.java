/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.Random;

/**
 *
 * @author kasper
 */
public class Tip implements ICommand {

    private Random random = new Random();
    private String[] tips = new String[]{
        "Quests ending with \"REPEATABLE\" can be done multiple times, and give rewards each time.",
        "You can do multiple actions each turn, as long as you have ability points left.",
        "Introduction Quests are a good place to start your journey.",
        "Class Quests will provide you with new skills.",
        "If you die during combat, there is no going back, you will begin from last save"
    };

    //TODO - add tip about stats
    
    @Override
    public String commandName() {
        return "!tip - Get shown a random tip";
    }

    @Override
    public void executeCommand() {
        System.out.println(tips[random.nextInt(tips.length)]);
    }

}
