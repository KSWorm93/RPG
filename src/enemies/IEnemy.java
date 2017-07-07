/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemies;

/**
 *
 * @author kasper
 */
public interface IEnemy {
    
    public void hit(int dmg);
    public int hitYou();
    public int healthPoints();
    public String name();
}
