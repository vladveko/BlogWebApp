package com.blogapp.service;

import com.blogapp.bean.User;

public interface ReaderService {
    void signIn(String login, String password);
    void signOut(String login);
    void registration(User user);

}
