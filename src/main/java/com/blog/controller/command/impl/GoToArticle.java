package com.blog.controller.command.impl;

import com.blog.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToArticle implements Command {

    private static final String ARTICLE_PAGE_URI = "WEB-INF/jsp/article.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(ARTICLE_PAGE_URI);
        rd.forward(request, response);
    }
}
