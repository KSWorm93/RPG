/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameEngine;

import character.classes.IClass;
import java.util.ArrayList;
import java.util.List;
import quests.IQuest;
import quests.classquest.rogue.RogueIntro;
import quests.classquest.warrior.WarriorIntro;
import quests.intro.Quests;
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

    public void addQuests(List<IQuest> quests) {
        if (quests != null) {
            this.quests.addAll(quests);
        }
    }

    //TODO - Only remove if not contain repeatable??
    public void removeQuest(IQuest quest) {
        if (quest.questName().contains("REPEATABLE")) {
            quests.remove(quest);
            reAddQuest(quest);
        } else {
            quests.remove(quest);
        }
    }

    public IQuest getSingleQuest(int questToGet) {
        return quests.get(questToGet);
    }

    public void initClassStoryline(IClass className) {
        if ("Warrior".equals(className.className())) {
            warriorQuests();
        } else if ("Rogue".equals(className.className())) {
            rogueQuests();
        }
    }

    private void rogueQuests() {
        quests.add(new Quests());
        quests.add(new RogueIntro());
        quests.add(new RandomEncounter());
    }

    private void warriorQuests() {
        quests.add(new Quests());
        quests.add(new WarriorIntro());
        quests.add(new RandomEncounter());
    }

    private void reAddQuest(IQuest quest) {
        quests.add(quest.questInstance());
    }

}
