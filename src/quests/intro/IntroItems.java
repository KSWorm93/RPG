/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.intro;

import character.item.IItem;
import character.item.Potion;
import enemies.IEnemy;
import enemies.SkeletonWarrior;
import java.util.ArrayList;
import java.util.List;
import quests.IQuest;
import quests.moves.IMove;
import quests.moves.Single;

/**
 *
 * @author kasper
 */
public class IntroItems implements IQuest {

    @Override
    public String questName() {
        return "Intro Quest - Items";
    }

    @Override
    public List<IEnemy> enemies() {
        List<IEnemy> enemies = new ArrayList();
        IEnemy skeletonWarrior = new SkeletonWarrior();

        enemies.add(skeletonWarrior);
        return enemies;
    }

    @Override
    public List<IMove> questMoves() {
        List<IMove> moves = new ArrayList();
        IMove firstMove = new Single(false);
        IMove secondMove = new Single(false);

        moves.add(firstMove);
        moves.add(secondMove);
        return moves;
    }

    @Override
    public List<String> questDialogue() {
        List<String> dialogue = new ArrayList();
        String first = "\nThis is an introductory quest"
                + "\nwhere you will learn basic features of items in the game";
        String second = "Items are something you can use during combat"
                + "\nThe effect will vary depending on your items"
                + "\nSome items will boost your offensive power"
                + "\nWhile others will have heal you or debuff your enemy";

        dialogue.add(first);
        dialogue.add(second);

        return dialogue;
    }

    @Override
    public IQuest questInstance() {
        return new Intro();
    }

    @Override
    public List<IQuest> questUnlocks() {
        return null;
    }

    @Override
    public IItem itemReward() {
        Potion tinyHealingPotion = new Potion("Tiny Healing Potion", "Healing Potion", 10);
        return tinyHealingPotion;
    }

}
