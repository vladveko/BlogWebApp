package com.blog.controller.command.impl;

import com.blog.bean.Article;
import com.blog.controller.command.Command;
import com.blog.service.BlogService;
import com.blog.service.ServiceProvider;
import com.blog.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetArticle implements Command {

    private static final String ARTICLE_ID = "articleID";
    private static final String REDIRECT = "Controller?com=gotoarticle";
    private static final String REDIRECT_ERROR = "Controller?com=gotoarticle&error=true";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BlogService blogService = serviceProvider.getBlogService();

        try{
            long articleID = Integer.parseInt(request.getParameter(ARTICLE_ID));
            Article article = blogService.getArticle(articleID);

            session.setAttribute("article", article);
            response.sendRedirect(REDIRECT);
        }
        catch (ServiceException ex){
            response.sendRedirect(REDIRECT_ERROR);
        }

    }
}
