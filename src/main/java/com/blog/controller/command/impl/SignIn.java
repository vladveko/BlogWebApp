package com.blog.controller.command.impl;

import com.blog.bean.User;
import com.blog.controller.command.Command;
import com.blog.service.ReaderService;
import com.blog.service.ServiceProvider;
import com.blog.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignIn implements Command {

    private static final String REQUEST_PARAM_LOGIN = "login";
    private static final String REQUEST_PARAM_PASSWORD = "password";
    private static final String REDIRECT_COMMAND_SUCCESS = "Controller?command=gotomain";
    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=gotomain&error=error";
    private static final String USER_SESSION_ATTR = "user";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter(REQUEST_PARAM_LOGIN);
        String password = req.getParameter(REQUEST_PARAM_PASSWORD);

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        ReaderService readerService = serviceProvider.getReaderService();
        HttpSession session = req.getSession(true);

        try {
            User user = readerService.signIn(login, password.getBytes());

            if(user == null)
                resp.sendRedirect(REDIRECT_COMMAND_ERROR);
            else {
                session.setAttribute(USER_SESSION_ATTR, user);
                resp.sendRedirect(REDIRECT_COMMAND_SUCCESS);
            }
        }
        catch (ServiceException e) {
            resp.sendRedirect(REDIRECT_COMMAND_ERROR);
        }
    }
}
