/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemies;

import character.stats.Stat;

/**
 *
 * @author kasper
 */
public class SkeletonWarrior implements IEnemy {

    private Stat health = new Stat("Health Points", 20);
    private int hit = 2;

    @Override
    public int hitYou() {
        return hit;
    }

    @Override
    public void hit(int dmg) {
        int temp = health.getStatValue() - dmg;
        health.setStatValue(temp);
    }

    @Override
    public int healthPoints() {
        return health.getStatValue();
    }

    @Override
    public String name() {
        return "Skeleton Warrior";
    }

}
