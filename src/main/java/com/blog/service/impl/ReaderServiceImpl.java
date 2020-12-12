package com.blog.service.impl;

import com.blog.bean.User;
import com.blog.dao.DAOProvider;
import com.blog.dao.UserDAO;
import com.blog.dao.exception.DAOException;
import com.blog.service.ReaderService;
import com.blog.service.exception.ServiceException;

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
    public boolean signOut(String login) {
        return true;
    }

    @Override
    public void registration(User user) {

    }
}
