package com.blogapp.controller.command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider(){

    }

    public Command getCommand(String commandName){
        return commands.get(commandName);

    }
}
