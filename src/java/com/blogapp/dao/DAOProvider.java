package com.blogapp.dao;

import com.blogapp.dao.impl.SQLUserDAO;
import com.blogapp.dao.impl.SQLArticalDAO;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new SQLUserDAO();
    private final ArticalDAO articalDAO = new SQLArticalDAO();

    private DAOProvider() {};

    public static DAOProvider getInstance(){
        return instance;
    }

    public UserDAO getUserDAO() { return userDAO; }

    public ArticalDAO getArticalDAO() { return articalDAO; }

}
