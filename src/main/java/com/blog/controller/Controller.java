package com.blog.controller;

import com.blog.controller.command.Command;
import com.blog.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Controller")
public class Controller extends HttpServlet {

    private static final String REQUEST_PARAMETER_COMMAND = "command";
    private static final String LAST_REQUEST_PARAM = "lastRequest";

    private final CommandProvider provider = new CommandProvider();

    public Controller() { super(); }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processGetRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processPostRequest(request, response);
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String commandName;
        Command executionCommand;

        commandName = req.getParameter(REQUEST_PARAMETER_COMMAND);

        executionCommand = provider.getCommand(commandName);
        executionCommand.execute(req,resp);

        req.getSession(true).setAttribute(LAST_REQUEST_PARAM, req.getRequestURI() + "?" + req.getQueryString());
    }

    private void processPostRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String commandName;
        Command executionCommand;

        commandName = req.getParameter(REQUEST_PARAMETER_COMMAND);
        executionCommand = provider.getCommand(commandName);

        executionCommand.execute(req,resp);
    }
}
