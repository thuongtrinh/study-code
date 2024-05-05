package com.txt.junit.test.junit5.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloWorldServiceTest {

    @Autowired
    HelloWorldService helloWorldService;

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void testGet() {
        Assertions.assertEquals("Hello JUnit 5", helloWorldService.get());
    }
}
