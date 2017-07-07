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
public class Exit implements ICommand{

    @Override
    public String commandName() {
        return "!exit - Exit the game";
    }

    @Override
    public void executeCommand() {
        System.out.println("Exited game - Hope u had fun.");
        System.exit(0);
    }
    
}
