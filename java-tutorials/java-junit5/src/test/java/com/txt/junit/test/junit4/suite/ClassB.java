package com.txt.junit.test.junit4.suite;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({PerformanceTests.class})
public class ClassB {

    @Test
    public void test_B1() {
        Assert.assertTrue(true);
    }

    @Test
    public void test_B2() {
        Assert.assertTrue(true);
    }
}
