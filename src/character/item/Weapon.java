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
public class Weapon implements IItem{

    private String weaponName;
    private String type;
    private String rarity;
    private int attackValue;
    private int blockChance;

    public Weapon(String weaponName, String type, String rarity, int attackValue, int blockChance) {
        this.weaponName = weaponName;
        this.type = type;
        this.rarity = rarity;
        this.attackValue = attackValue;
        this.blockChance = blockChance;
    }
    
    @Override
    public String name() {
        return weaponName;
    }

    @Override
    public String type() {
        return type;
    }
    
    public String rarity(){
        return rarity;
    }
    
    public int attackValue(){
        return attackValue;
    }
    
    public int blockChance(){
        return blockChance;
    }

    @Override
    public int cost() {
        return 10;
    }
    
}
