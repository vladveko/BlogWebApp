package com.blog.controller.command;

import com.blog.controller.command.impl.GetAllArticles;
import com.blog.controller.command.impl.GetArticle;
import com.blog.controller.command.impl.GoToMainPage;
import com.blog.controller.command.impl.SignIn;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider(){

        commands.put("signin", new SignIn());
        commands.put("gotomainpage", new GoToMainPage());
        commands.put("getallarticles", new GetAllArticles());
        commands.put("getarticle", new GetArticle());
    }

    public Command getCommand(String commandName){
        return commands.get(commandName);

    }
}
