/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.mainquest;

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
public class Intro implements IQuest {

    @Override
    public String questName() {
        return "Intro Quest - Basic movement";
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
        IMove secondMove = new Duo(false);
        IMove thirdMove = new Triple(false);

        moves.add(firstMove);
        moves.add(secondMove);
        moves.add(thirdMove);
        return moves;
    }

    @Override
    public List<String> questDialogue() {
        List<String> dialogue = new ArrayList();
        String first = "\nThis is an introductory quest"
                + "\nwhere you will learn basic movement in the game";
        String second = "Movement is simple, you get a list of options,"
                + "\nand choose from them by typing in a number, "
                + "\naccording to where you want to go.";
        String third = "This concludes the tutorial"
                + "\nEnter final number to finish the quest";

        dialogue.add(first);
        dialogue.add(second);
        dialogue.add(third);

        return dialogue;
    }

    @Override
    public IQuest questInstance() {
        return new Intro();
    }

    @Override
    public List<IQuest> questUnlocks() {
        List<IQuest> quests = new ArrayList();
        quests.add(new WarriorIntro());
        return quests;
    }
    
    @Override
    public String statReward(){
        return "Strength";
    }

}
