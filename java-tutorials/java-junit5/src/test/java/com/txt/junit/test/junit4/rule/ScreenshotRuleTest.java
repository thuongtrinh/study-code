package com.txt.junit.test.junit4.rule;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;

public class ScreenshotRuleTest {

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule();

    @Test
    public void testScreenShot() throws IOException {
        throw new IOException("Application is crashed");
    }
}
