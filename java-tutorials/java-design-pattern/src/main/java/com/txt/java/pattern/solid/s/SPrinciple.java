package com.txt.java.pattern.solid.s;

import com.txt.java.pattern.entity.User;

/**
 * @Comment Single responsibility principle (SRP)
 * @Define A class should have one and only one reason to change, meaning that a
 * class should have only one job.
 */
public class SPrinciple {

    public User getUser() {
        return null;
    }

    public boolean insertUser() {
        // stuff code
        return true;
    }

    public boolean updateUser() {
        // stuff code
        return true;
    }

    public boolean deleteUser() {
        // stuff code
        return true;
    }
}
