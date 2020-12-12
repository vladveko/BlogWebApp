package com.blog.dao;

import com.blog.dao.impl.SQLUserDAO;
import com.blog.dao.impl.SQLArticleDAO;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new SQLUserDAO();
    private final ArticleDAO articleDAO = new SQLArticleDAO();

    private DAOProvider() {};

    public static DAOProvider getInstance(){
        return instance;
    }

    public UserDAO getUserDAO() { return userDAO; }

    public ArticleDAO getArticleDAO() { return articleDAO; }

}
