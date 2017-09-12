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
    private int amount;
    private int value;

    public Potion(String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    /**
     * Use this if you want different default value for cost
     *
     * @param name
     * @param type
     * @param amount
     * @param value
     */
    public Potion(String name, String type, int amount, int value) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.value = value;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String type() {
        return type;
    }

    public int amount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int value() {
        return 4;
    }

}
