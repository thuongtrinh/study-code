package com.txt.junit.test.junit4.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SuppressMethod.class)
public class SuppressMethodTest {

    @Test
    public void testMockDoNothing() throws Exception {
        SuppressMethod tested = PowerMockito.spy(new SuppressMethod("com.txt"));
        PowerMockito.doNothing().when(tested, "checkPermission");
        Assert.assertEquals("admin@com.txt", tested.getUsername());
    }

    @Test
    public void testSuppressMethod() throws Exception {
        SuppressMethod tested = new SuppressMethod("com.txt");
        PowerMockito.suppress(PowerMockito.method(SuppressMethod.class, "checkPermission"));
        Assert.assertEquals("admin@com.txt", tested.getUsername());
    }
}
