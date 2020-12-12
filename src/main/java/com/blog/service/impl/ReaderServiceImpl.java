package com.blog.service.impl;

import com.blog.bean.User;
import com.blog.dao.DAOProvider;
import com.blog.dao.UserDAO;
import com.blog.dao.exception.DAOException;
import com.blog.dao.exception.UserExistsDAOException;
import com.blog.service.ReaderService;
import com.blog.service.exception.ServiceException;
import com.blog.service.exception.UserExistsServiceException;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public User signIn(String login, byte[] password) throws ServiceException {

        if(login.equals("") || password.length == 0)
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
    public boolean registration(String login, byte[] password, String firstname,
                                String lastname, String email, int roleID) throws ServiceException {

        if (login.isEmpty() || password.length == 0 || firstname.isEmpty()
                || lastname.isEmpty() || email.isEmpty())
            return false;

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        try {
            userDAO.registration(login, password, firstname, lastname, email, roleID);
        }
        catch (UserExistsDAOException ex){
            throw new UserExistsServiceException("This login is taken", ex);
        }
        catch (DAOException ex){
            throw new ServiceException("Registration error", ex);
        }
        return true;
    }
}
