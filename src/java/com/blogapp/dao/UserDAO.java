package com.blogapp.dao;

import com.blogapp.bean.User;
import com.blogapp.dao.exception.DAOException;

public interface UserDAO {
    User signIn(String login, byte[] password) throws DAOException;
    void registration(User user);
}
