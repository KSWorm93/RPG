/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import gameEngine.ClassHandler;
import utils.PrintHelper;

/**
 *
 * @author kasper
 */
public class ClassInformation implements ICommand{

    PrintHelper printer = new PrintHelper();
    
    @Override
    public String commandName() {
        return "!info - Gives information about your class";
    }

    @Override
    public void executeCommand() {
        printer.printClassStats(ClassHandler.getStats());
    }
    
}
