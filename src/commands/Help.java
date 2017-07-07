/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import utils.CommandHandler;
import utils.PrintHelper;

/**
 *
 * @author kasper
 */
public class Help implements ICommand{
    
    PrintHelper printer = new PrintHelper();

    @Override
    public String commandName() {
        return "!help - List all commands available.";
    }

    @Override
    public void executeCommand() {
        printer.printAvailableCommands(CommandHandler.getCommands());
    }
    
}
