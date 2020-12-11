package com.blogapp.service.impl;

import com.blogapp.bean.User;
import com.blogapp.dao.DAOProvider;
import com.blogapp.dao.UserDAO;
import com.blogapp.dao.exception.DAOException;
import com.blogapp.service.ReaderService;
import com.blogapp.service.exception.ServiceException;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public User signIn(String login, byte[] password) throws ServiceException {

        if(login.equals("") || password.equals(""))
            return null;

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        try {
            return userDAO.signIn(login, password);
        }
        catch (DAOException e) {
            throw new ServiceException("Error while signing in", e);
        }
    }

    @Override
    public void signOut(String login) {

    }

    @Override
    public void registration(User user) {

    }
}
