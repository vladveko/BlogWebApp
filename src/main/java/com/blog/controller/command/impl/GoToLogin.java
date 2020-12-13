package com.blog.controller.command.impl;

import com.blog.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToLogin implements Command {

    private static final String REDIRECT = "WEB-INF/jsp/login.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
