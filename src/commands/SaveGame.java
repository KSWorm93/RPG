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
public class SaveGame implements ICommand{

    @Override
    public String commandName() {
        return "!save - Save your current progress";
    }

    @Override
    public void executeCommand() {
        //TODO - to be implemented
    }
    
}
