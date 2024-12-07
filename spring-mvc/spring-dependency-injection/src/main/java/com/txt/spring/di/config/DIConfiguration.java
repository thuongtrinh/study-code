package com.txt.spring.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.txt.spring.di.services.EmailService;
import com.txt.spring.di.services.MessageService;

@Configuration
@ComponentScan(value = {"com.txt.spring.di.consumer"})
public class DIConfiguration {

    @Bean
    public MessageService getMessageService() {
        return new EmailService();
        //return new TwitterService();
    }
}
