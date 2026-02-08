package com.txt.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.txt.spring.beans.MyBean;

public class MyMainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
        MyService service = ctx.getBean(MyService.class);

        service.log("Hi");

        MyService newService = ctx.getBean(MyService.class);
        System.out.println("service hashcode=" + service.hashCode());
        System.out.println("newService hashcode=" + newService.hashCode());
        ctx.close();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean app = context.getBean(MyBean.class);
        System.out.println("name: " + app.getName());
        System.out.println("name: " + app.getId());
    }

}
