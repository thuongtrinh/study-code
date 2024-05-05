package com.txt.junit.test.junit4.basic;

import com.txt.junit.test.common.utils.MathUtil;
import org.junit.Test;

public class ExceptionTest1 {

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() throws Exception {
        MathUtil.divide(1, 0);
    }

}
