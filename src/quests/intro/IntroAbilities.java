/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.intro;

import character.abilities.DefensiveAbility;
import character.abilities.IAbility;
import enemies.IEnemy;
import enemies.SkeletonWarrior;
import java.util.ArrayList;
import java.util.List;
import quests.IQuest;
import quests.classquest.warrior.WarriorIntro;
import quests.moves.Duo;
import quests.moves.IMove;
import quests.moves.Single;
import quests.moves.Triple;

/**
 *
 * @author kasper
 */
public class IntroAbilities implements IQuest {

    @Override
    public String questName() {
        return "Intro Quest - Abilities";
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
        IMove thirdMove = new Single(false);
        IMove forthMove = new Single(false);

        moves.add(firstMove);
        moves.add(secondMove);
        moves.add(thirdMove);
        moves.add(forthMove);
        return moves;
    }

    @Override
    public List<String> questDialogue() {
        List<String> dialogue = new ArrayList();
        String first = "\nThis is an introductory quest"
                + "\nwhere you will learn basic abilities in the game";
        String second = "There is many different kinds of abilities"
                + "\nOffensive and defensive abilities";
        String third = "Defensive Abilities"
                + "\nThese abilities will heal or buff you"
                + "\nso you are able to stay in the fight for longer";
        String forth = "Offensive Abilities"
                + "\nThese are your damaging and debuffing abilities"
                + "\nYOu use them to beat your opponent";

        dialogue.add(first);
        dialogue.add(second);
        dialogue.add(third);
        dialogue.add(forth);

        return dialogue;
    }

    @Override
    public IQuest questInstance() {
        return new Intro();
    }

    @Override
    public List<IQuest> questUnlocks() {
        List<IQuest> quests = new ArrayList();
        quests.add(new IntroItems());
        return quests;
    }

    @Override
    public IAbility abilityReward() {
        DefensiveAbility firstAid = new DefensiveAbility("Defensive", "First Aid", 4, 10, 1);
        return firstAid;
    }

}
