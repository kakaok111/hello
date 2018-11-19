package com.g.service;

import com.g.beans.User;

public class UserService {
    public User login(User user) {
        if (user.getUsername().equals("whg") && user.getPassword().equals("123")) {
        } else {
            user = null;

        }
        return user;
    }
}
