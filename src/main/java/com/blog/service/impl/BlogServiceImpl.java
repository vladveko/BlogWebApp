package com.blog.service.impl;

import com.blog.bean.Article;
import com.blog.bean.ArticleInformation;
import com.blog.dao.ArticleDAO;
import com.blog.dao.DAOProvider;
import com.blog.dao.exception.DAOException;
import com.blog.service.BlogService;
import com.blog.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService{

    @Override
    public void addNewArticle(Article article) throws ServiceException{

    }

    @Override
    public void addEditedArticle(Article article) throws ServiceException{

    }

    @Override
    public ArrayList<ArticleInformation> getHeaders() throws ServiceException {
        DAOProvider daoProvider = DAOProvider.getInstance();
        ArticleDAO articleDAO = daoProvider.getArticleDAO();

        try{
            return articleDAO.getHeaders();
        }
        catch (DAOException ex){
            throw new ServiceException("Error getting articles headers", ex);
        }
    }

    @Override
    public Article getArticle(int id) throws ServiceException{
        DAOProvider daoProvider = DAOProvider.getInstance();
        ArticleDAO articleDAO = daoProvider.getArticleDAO();

        try{
            return articleDAO.getArticle(id);
        }
        catch (DAOException ex){
            throw new ServiceException("Error getting full article", ex);
        }
    }
}
