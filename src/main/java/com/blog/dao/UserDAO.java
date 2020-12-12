package com.blog.dao;

import com.blog.bean.User;
import com.blog.dao.exception.DAOException;

public interface UserDAO {
    User signIn(String login, byte[] password) throws DAOException;
    void registration(User user);
}
