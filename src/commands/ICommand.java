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
public interface ICommand {
    
    public String commandName();
    
    public void executeCommand();
    
}
