package com.blogapp.dao;

import com.blogapp.bean.User;

public interface UserDAO {
    void signIn(String login, String password);
    void registration(User user);
}
