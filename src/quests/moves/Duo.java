/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quests.moves;

/**
 *
 * @author kasper
 */
public class Duo implements IMove {

    private boolean encounter;

    public Duo(boolean encounter) {
        this.encounter = encounter;
    }

    public void setEncounter(boolean encounter) {
        this.encounter = encounter;
    }

    @Override
    public int numberOfMoves() {
        return 2;
    }

    @Override
    public boolean encounter() {
        return encounter;
    }

}
