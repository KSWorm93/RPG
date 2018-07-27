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

    String getType();
    void setType(String type);
    String getName();
    void setName(String name);
    int getCost();
    void setCost(int cost);
    int getTier();
    void setTier(int tier);
    int getValue();
    void setValue(int value);

}
