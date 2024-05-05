package com.txt.junit.test.junit5.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceMockTest {

    @Mock
    private HelloWorldRepository helloRepository;

    @InjectMocks // auto inject helloRepository
    private HelloWorldService helloService = new HelloWorldService();

    @BeforeEach
    void setMockOutput() {
        Mockito.when(helloRepository.get()).thenReturn("Hello Mockito From Repository");
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        Assertions.assertEquals("Hello Mockito From Repository", helloService.get());
    }
}
