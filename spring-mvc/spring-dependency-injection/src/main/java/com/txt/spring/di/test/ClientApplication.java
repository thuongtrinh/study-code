package com.txt.spring.di.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.txt.spring.di.config.DIConfiguration;
import com.txt.spring.di.consumer.MyApplication;

public class ClientApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);

        app.processMessage("Hi Smitn", "smith@abc.com");

        // close the context
        context.close();
    }

}
