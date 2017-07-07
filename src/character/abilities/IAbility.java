/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.abilities;

/**
 *
 * @author kasper
 */
public interface IAbility {

    public String getType();

    public void setType(String type);

    public String getName();

    public void setName(String name);

    public int getCost();

    public void setCost(int cost);
    
    public int getTier();
    
    public void setTier(int tier);
    
    public int getValue();
    
    public void setValue(int value);

}
