/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.stats;

/**
 *
 * @author kasper
 */
public class Stat {
    
    private String statName;
    private int statValue;

    public Stat(String statName, int statValue) {
        this.statName = statName;
        this.statValue = statValue;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public int getStatValue() {
        return statValue;
    }

    public void setStatValue(int statValue) {
        this.statValue = statValue;
    }
    
    
    
    
}
