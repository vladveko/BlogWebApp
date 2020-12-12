package com.blog.controller.command;

import com.blog.controller.command.impl.SignIn;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put("signin", new SignIn());
    }

    public Command getCommand(String commandName){
        return commands.get(commandName);

    }
}
