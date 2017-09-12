/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.mainquest.intro;

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
public class IntroStats implements IQuest {

    @Override
    public String questName() {
        return "Intro Quest - Stat Rewards";
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
        IMove fifthMove = new Single(false);
        IMove sixthMove = new Single(false);
        IMove seventhMove = new Single(false);
        IMove eigthMove = new Single(false);

        moves.add(firstMove);
        moves.add(secondMove);
        moves.add(thirdMove);
        moves.add(forthMove);
        moves.add(fifthMove);
        moves.add(sixthMove);
        moves.add(seventhMove);
        moves.add(eigthMove);
        return moves;
    }

    @Override
    public List<String> questDialogue() {
        List<String> dialogue = new ArrayList();
        String intro = "\nThis is an introductory quest"
                + "\nwhere you will learn basic Stats";
        String strength = "Strength is your physical stat"
                + "\ndetermining your power when using physical abilities";
        String agility = "Agility is your defensive stat"
                + "\ndetermining your ability to evade attacks";
        String intelligence = "Intelligence is your magical stat"
                + "\ndetermining your power when using magical abilities";
        String hp = "Health Points is your health pool"
                + "\nThis gives you an indication on how much damage you can take "
                + "\nIf you reach 0, you will die, and its game over";
        String abilityPoints = "Ability Points is your action pool"
                + "\nThis gives you an indication on how many actions you can still do"
                + "\nIf your Action Points reach 0, you can no longer make any moves";
        String exp = "Experience Points"
                + "\nThis gives you an indication on how you are till your next level"
                + "\nWhen you reach 100 points you will level up";
        String level = "This shows you what level you are"
                + "\nWhen you level up you will receive rewards";
        
        dialogue.add(intro);
        dialogue.add(strength);
        dialogue.add(agility);
        dialogue.add(intelligence);
        dialogue.add(hp);
        dialogue.add(abilityPoints);
        dialogue.add(exp);
        dialogue.add(level);
        return dialogue;
    }

    @Override
    public IQuest questInstance() {
        return new Intro();
    }

    @Override
    public List<IQuest> questUnlocks() {
        List<IQuest> quests = new ArrayList();
        quests.add(new IntroAbilities());
        return quests;
    }
    
    @Override
    public String statReward(){
        return "Strength";
    }

}
