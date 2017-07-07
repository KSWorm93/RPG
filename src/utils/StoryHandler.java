/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import quests.IQuest;

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

    private void reAddQuest(IQuest quest) {
        quests.add(quest.questInstance());
    }

    private void initClassStoryline() {

    }

}
