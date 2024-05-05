package com.txt.junit.test.junit4.basic;

import com.txt.junit.test.common.utils.MathUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest3 {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() throws Exception {
        // Keep this ordering: expect -> call the method which throw an exception
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot divide by zero (0).");

        MathUtil.divide(1, 0);
    }

}
