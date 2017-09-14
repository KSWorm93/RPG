/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.item;

/**
 *
 * @author kasper
 */
public class Potion implements IItem {

    private String name;
    private String type;
    private int cost;

    public Potion(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Use this if you want different default value for cost Cost should not be
     * bigger than 4
     *
     * @param name
     * @param type
     * @param cost
     */
    public Potion(String name, String type, int cost) {
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String type() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * OBS - Cost will default to 4 during combat So no reason to add cost > 4
     *
     * @return cost
     */
    @Override
    public int cost() {
        return cost;
    }

}
