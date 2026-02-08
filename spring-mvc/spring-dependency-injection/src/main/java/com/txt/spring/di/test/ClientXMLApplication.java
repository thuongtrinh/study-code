package com.txt.spring.di.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.txt.spring.di.consumer.MyXMLApplication;

public class ClientXMLApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyXMLApplication app = context.getBean(MyXMLApplication.class);

        app.processMessage("Hi Smith", "smith@abc.com");

        // close the context
        context.close();
    }

}
