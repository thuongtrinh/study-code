package com.txt.junit.test.junit4.mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TimeoutTest {

    @InjectMocks
    private CustomList mockedList;

    @Mock
    private List<String> list;

    @Before
    public void prepareForTest() {
        // Mock creation
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Verification will be triggered after given amount of millis, allowing
     * testing of async code.
     * <p>
     * timeout() exits immediately with success when verification passes
     */
    @Test
    public void timeoutTest() {
        // Using mock object
        mockedList.add("com.txt");

        // Verify call to add method to be called once times within 100 ms
        Mockito.verify(list, Mockito.timeout(100)).add("com.txt"); // Default once times
        Mockito.verify(list, Mockito.timeout(100).times(1)).add("com.txt");
    }

    /**
     * Verification will be triggered after given amount of millis, allowing
     * testing of async code.
     * <p>
     * after() awaits full duration to check if verification passes
     */
    @Test
    public void afterTest() {
        // Using mock object
        mockedList.add("com.txt");

        // Verify call to add method to be called once times within 100 ms
        Mockito.verify(list, Mockito.after(100)).add("com.txt"); // Default once times
        Mockito.verify(list, Mockito.after(100).times(1)).add("com.txt");
    }
}
