package com.blog.dao.impl;

import com.blog.bean.User;
import com.blog.dao.UserDAO;
import com.blog.dao.exception.DAOException;

public class SQLUserDAO implements UserDAO{

    @Override
    public User signIn(String login, byte[] password) throws DAOException {
        return null;
    }

    @Override
    public void registration(User user) {

    }
}
