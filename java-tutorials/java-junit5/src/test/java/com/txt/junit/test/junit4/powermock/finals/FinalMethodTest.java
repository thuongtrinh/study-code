package com.txt.junit.test.junit4.powermock.finals;

import com.txt.junit.test.common.utils.FinalMethod;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FinalMethod.class})
public class FinalMethodTest {

    @Test
    public void mockFinalClazzTest() {
        FinalMethod mockedObject = PowerMockito.mock(FinalMethod.class);
        PowerMockito.when(mockedObject.doSomething()).thenReturn("com.txt");

        Assert.assertEquals("com.txt", mockedObject.doSomething());
    }

    @Test
    public void spyFinalClazzTest() {
        FinalMethod mockedObject = PowerMockito.spy(new FinalMethod());
        Assert.assertEquals("com.txt", mockedObject.doSomething());
    }
}
