package com.txt.junit.test.junit4.powermock.statics;

import java.util.UUID;

import com.txt.junit.test.common.utils.UserUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserUtils.class})
public class UserService3Test {

    @Test
    public void verifyCalledStaticMethodTest() throws Exception {
        // Object under test
        UserService3 userService = new UserService3();

        // Mock
        PowerMockito.mockStatic(UserUtils.class);
        PowerMockito.doNothing().when(UserUtils.class, "validate", Mockito.anyString());
        PowerMockito.when(UserUtils.class, "generateUniqueId").thenReturn(UUID.randomUUID().toString());

        // Execute method under test
        String actual = userService.insert();

        // Test
        Assert.assertEquals("com.txt", actual);
        PowerMockito.verifyStatic(UserUtils.class, Mockito.times(2));
        UserUtils.validate(Mockito.anyString());
        PowerMockito.verifyStatic(UserUtils.class, Mockito.times(1));
        UserUtils.generateUniqueId();
    }
}

