package com.txt.junit.test.junit4.basic;

import com.txt.junit.test.common.utils.MathUtil;
import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest2 {

    @Test
    public void testDivideByZero() throws Exception {
        try {
            MathUtil.divide(1, 9);
            Assert.fail("Not throw an exception");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
            Assert.assertEquals("Cannot divide by zero (0).", e.getMessage());
        }
    }

}
