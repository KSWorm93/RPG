/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import character.classes.IClass;
import java.util.ArrayList;
import java.util.List;
import quests.IQuest;
import quests.classquest.rogue.RogueIntro;
import quests.classquest.warrior.WarriorIntro;
import quests.mainquest.Intro;
import quests.sidequest.RandomEncounter;

/**
 *
 * @author kasper
 */
public class StoryHandler {

    private List<IQuest> quests = new ArrayList();

    public List<IQuest> getQuests() {
        return quests;
    }

    public void addQuest(IQuest quest) {
        quests.add(quest);
    }

    public void removeQuest(IQuest quest) {
        if (!quest.questName().contains("REPEATABLE")) {
            quests.remove(quest);
        }
    }

    public IQuest getSingleQuest(int questToGet) {
        return quests.get(questToGet);
    }

    public void initClassStoryline(IClass className) {
        if("Warrior".equals(className.className())){
            warriorQuests();
        } else if("Rogue".equals(className.className())){
            rogueQuests();
        }
    }
    
    private void rogueQuests(){
        quests.add(new Intro());
        quests.add(new RandomEncounter());
        quests.add(new RogueIntro());
    }
    
    private void warriorQuests(){
        quests.add(new Intro());
        quests.add(new RandomEncounter());
        quests.add(new WarriorIntro());
    }

}
