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
public class OffensiveAbility implements IAbility {

    private String type;
    private String name;
    private int cost;
    private int value;
    private int tier;

    public OffensiveAbility(String myType, String myName, int myCost, int myValue, int myTier) {
        this.type = myType;
        this.name = myName;
        this.cost = myCost;
        this.value = myValue;
        this.tier = myTier;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

}
