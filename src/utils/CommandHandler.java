/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import commands.About;
import commands.ClassInformation;
import commands.Exit;
import commands.Help;
import commands.ICommand;
import commands.LoadGame;
import commands.SaveGame;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kasper
 */
public class CommandHandler {

    private static List<ICommand> commands;

    public void initCommands() {
        commands = new ArrayList();

        commands.add(new Help());
        commands.add(new About());
        commands.add(new SaveGame());
        commands.add(new LoadGame());
        commands.add(new ClassInformation());
        commands.add(new Exit());
    }

    public static List<ICommand> getCommands() {
        return commands;
    }

    public void executeCommand(int index) {
        commands.get(index).executeCommand();
    }

    public void executeCommand(String name) {
        for (ICommand command : commands) {
            if (command.commandName().contains(name)) {
                command.executeCommand();
            }
        }
    }

    public boolean checkForCommand(String command) {
        if (command.contains("!")) {
            System.out.println("\ncommand detected");
            return true;
        } else {
            return false;
        }
    }

}
