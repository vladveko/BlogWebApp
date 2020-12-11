package com.blogapp.dao.impl;

import com.blogapp.bean.User;
import com.blogapp.dao.UserDAO;
import com.blogapp.dao.exception.DAOException;

public class SQLUserDAO implements UserDAO{

    @Override
    public User signIn(String login, byte[] password) throws DAOException {
        return null;
    }

    @Override
    public void registration(User user) {

    }
}
