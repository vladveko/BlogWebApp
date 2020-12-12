package com.blog.controller.command;

import com.blog.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider(){

        commands.put("signin", new SignIn());
        commands.put("signout", new SignOut());
        commands.put("gotomainpage", new GoToMainPage());
        commands.put("getallarticles", new GetAllArticles());
        commands.put("getarticle", new GetArticle());
        commands.put("gotoarticle", new GoToArticle());
        commands.put("gotoarticles", new GoToArticles());
        commands.put("gotoregistration", new GoToRegistration());
        commands.put("register", new Register());
    }

    public Command getCommand(String commandName){
        return commands.get(commandName);

    }
}
