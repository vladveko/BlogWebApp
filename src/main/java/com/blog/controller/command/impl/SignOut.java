package com.blog.controller.command.impl;

import com.blog.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOut implements Command {

    private static final String REDIRECT = "Controller?com=gotomain";
    private static final String USER_SESSION_ATTR = "user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute(USER_SESSION_ATTR);

        response.sendRedirect(REDIRECT);
    }
}
