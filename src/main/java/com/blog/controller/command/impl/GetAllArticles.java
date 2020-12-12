package com.blog.controller.command.impl;

import com.blog.bean.ArticleInformation;
import com.blog.controller.command.Command;
import com.blog.service.BlogService;
import com.blog.service.ServiceProvider;
import com.blog.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class GetAllArticles implements Command {

    private static final String REDIRECT = "Controller?com=gotoarticles";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BlogService blogService = serviceProvider.getBlogService();

        try {
            ArrayList<ArticleInformation> headers = blogService.getHeaders();

            session.setAttribute("headers", headers);
            response.sendRedirect(REDIRECT);
        }
        catch (ServiceException ex){
            response.sendRedirect(REDIRECT);
        }
    }
}
