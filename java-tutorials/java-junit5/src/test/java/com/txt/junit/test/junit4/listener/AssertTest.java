package com.txt.junit.test.junit4.listener;

import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void assertTrueTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void assertFalseTest() {
        Assert.assertFalse(false);
    }
}

