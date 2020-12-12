package com.blog.service;

import com.blog.bean.User;
import com.blog.service.exception.ServiceException;

public interface ReaderService {
    User signIn(String login, byte[] password) throws ServiceException;
    boolean signOut(String login);
    void registration(User user);

}
