package com.blog.controller.command.impl;

import com.blog.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToArticles implements Command {

    private static final String ARTICLES_PAGE_URI = "WEB-INF/jsp/articles.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(ARTICLES_PAGE_URI);
        rd.forward(request, response);
    }
}
