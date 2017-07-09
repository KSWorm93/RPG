/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.classquest.rogue;

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
public class RogueIntro implements IQuest {

    @Override
    public String questName() {
        return "Class tutorial for the Rogue";
    }

    @Override
    public List<IEnemy> enemies() {
        List<IEnemy> enemies = new ArrayList();
        IEnemy skelWarrior = new SkeletonWarrior();

        enemies.add(skelWarrior);

        return enemies;
    }

    @Override
    public List<IMove> questMoves() {
        List<IMove> moves = new ArrayList();
        IMove firstMove = new Single(true);
        IMove secondMove = new Single(false);

        moves.add(firstMove);
        moves.add(secondMove);
        return moves;
    }

    @Override
    public List<String> questDialogue() {
        List<String> dialogue = new ArrayList();
        String first = "\nIn this tutorial you will learn to fight off enemies";
        String second = "\nYou did it! You defeated the Skeleton Warrior!"
                + "\nMove forward to exit combat";

        dialogue.add(first);
        dialogue.add(second);

        return dialogue;
    }

    @Override
    public IQuest questInstance() {
        return new RogueIntro();
    }

}
