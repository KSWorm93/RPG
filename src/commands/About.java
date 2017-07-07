/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

/**
 *
 * @author kasper
 */
public class About implements ICommand{
    
    @Override
    public String commandName() {
        return "!about - Gives detail about the game and team behind it";
    }

    @Override
    public void executeCommand() {
        System.out.println("\nThis game is an RPG style dungeon crawler");
        System.out.println("It is currently in development");
        System.out.println("Made by Kasper Sylvest Worm");
        System.out.println("All code for the game will be made available,");
        System.out.println("on Kasper's github page.");
        System.out.println("Feel free to modify the game as you want");
        System.out.println("but give credit where credit is due.");
        System.out.println("If you need help. write !help");
        System.out.println("for a list of commands,");
        System.out.println("and follow on screen insctructions");
    }
    
}
