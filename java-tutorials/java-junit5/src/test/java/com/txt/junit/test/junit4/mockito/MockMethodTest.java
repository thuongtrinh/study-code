package com.txt.junit.test.junit4.mockito;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockMethodTest {

    @Test
    public void test() {
        // Mock creation
        List<String> mockedList = Mockito.mock(List.class);

        // Using mock object
        mockedList.add("com.txt");

        // Verifies certain behavior happened once
        Mockito.verify(mockedList).add("com.txt");

        // Method add() is not really called,
        // it run on mocked object, so the size always is 0
        Assert.assertEquals(0, mockedList.size());

        // We can assign the size of mocked object
        Mockito.when(mockedList.size()).thenReturn(5);
        Assert.assertEquals(5, mockedList.size());
    }

}
