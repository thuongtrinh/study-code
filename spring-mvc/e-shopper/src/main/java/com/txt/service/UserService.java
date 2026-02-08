package com.txt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.txt.dao.UserDAO;
import com.txt.dto.User;

@Service("userService")
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserDAO userDAO;

    public void saveUser(User user) {
//		try {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.add(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Save user was failed");
//		}
    }

    public List<User> findAllUsers() {
        return userDAO.listAllUsers();
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

}
