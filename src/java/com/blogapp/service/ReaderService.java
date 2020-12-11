package com.blogapp.service;

import com.blogapp.bean.User;
import com.blogapp.service.exception.ServiceException;

public interface ReaderService {
    User signIn(String login, byte[] password) throws ServiceException;
    void signOut(String login);
    void registration(User user);

}
