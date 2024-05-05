package com.txt.junit.test.junit5.hello;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldRepository {

    public String get() {
        return "Hello JUnit 5";
    }
}
