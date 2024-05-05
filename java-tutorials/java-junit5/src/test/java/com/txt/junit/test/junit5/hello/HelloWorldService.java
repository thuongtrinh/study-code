package com.txt.junit.test.junit5.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    @Autowired
    HelloWorldRepository helloWorldRepository;

    public String get() {
        return helloWorldRepository.get();
    }
}
