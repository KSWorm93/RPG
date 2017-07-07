/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests;

import enemies.IEnemy;
import java.util.List;
import quests.moves.IMove;

/**
 *
 * @author kasper
 */
public interface IQuest {
    public String questName();
    public List<IEnemy> enemies();
    public List<IMove> questMoves();
    public List<String> questDialogue();
}
