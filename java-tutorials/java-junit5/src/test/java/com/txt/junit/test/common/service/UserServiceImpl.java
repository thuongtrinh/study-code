package com.txt.junit.test.common.service;

import com.txt.junit.test.common.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String createUser(String email) {
        boolean result = userDao.createUser(email);

        if (result) {
            // Send an email verify ...
            // Show a success message to end user ...
            return "SUCCESS";
        }

        // Send an error message to end user ...
        return "FAILED";
    }
}
