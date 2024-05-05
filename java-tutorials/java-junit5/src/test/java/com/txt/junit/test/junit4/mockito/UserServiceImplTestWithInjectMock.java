package com.txt.junit.test.junit4.mockito;

import com.txt.junit.test.common.service.UserServiceImpl;
import com.txt.junit.test.common.dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserServiceImplTestWithInjectMock {

    // Create a mock object
    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createUser_WhenEmailExisted_ReturnFailed() {
        // Define return value for method createUser()
        Mockito.when(userDao.createUser("abc@com.txt")).thenReturn(false);

        // Use mock in test
        Assert.assertEquals("FAILED", userService.createUser("abc@com.txt"));
    }

    @Test
    public void createUser_WhenEmailNotExisted_ReturnSuccess() {
        // Define return value for method createUser()
        Mockito.when(userDao.createUser("abc@com.txt")).thenReturn(true);

        // Use mock in test
        Assert.assertEquals("SUCCESS", userService.createUser("abc@com.txt"));
    }
}
