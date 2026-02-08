package com.txt.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.txt.spring.service.MyAwareService;

public class SpringAwareMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aware.xml");

        System.out.println("------------------------------SpringAwareMain------------------------------");
        ctx.getBean("myAwareService", MyAwareService.class);

        ctx.close();
    }

}
