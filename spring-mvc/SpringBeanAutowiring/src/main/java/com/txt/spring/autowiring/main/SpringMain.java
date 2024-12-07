package com.txt.spring.autowiring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.txt.spring.autowiring.service.EmployeeAutowiredByConstructorService;
import com.txt.spring.autowiring.service.EmployeeAutowiredByTypeService;
import com.txt.spring.autowiring.service.EmployeeService;

public class SpringMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("----------------------------------------------------------------");
        EmployeeService serviceByName = ctx.getBean("employeeServiceByName", EmployeeService.class);
        System.out.println("Autowiring byName. Employee Name=" + serviceByName.getEmployee().getName());

        System.out.println("----------------------------------------------------------------");
        EmployeeService serviceByType = ctx.getBean("employeeServiceByType", EmployeeService.class);
        System.out.println("Autowiring byType. Employee Name=" + serviceByType.getEmployee().getName());

        System.out.println("----------------------------------------------------------------");
        EmployeeService serviceByConstructor = ctx.getBean("employeeServiceConstructor", EmployeeService.class);
        System.out.println("Autowiring by Constructor. Employee Name=" + serviceByConstructor.getEmployee().getName());

        // Printing hashcode to confirm all the objects are of different type
        System.out.println("----------------------------------------------------------------");
        System.out.println(serviceByName.hashCode() + "::" + serviceByType.hashCode() + "::" + serviceByConstructor.hashCode());

        System.out.println("----------------------------------------------------------------");
        // Testing @Autowired annotations
        EmployeeAutowiredByTypeService autowiredByTypeService = ctx.getBean("employeeAutowiredByTypeService", EmployeeAutowiredByTypeService.class);

        System.out.println("----------------------------------------------------------------");
        System.out.println("@Autowired byType. Employee Name=" + autowiredByTypeService.getEmployee().getName());
        EmployeeAutowiredByConstructorService autowiredByConstructorService = ctx.getBean("employeeAutowiredByConstructorService", EmployeeAutowiredByConstructorService.class);

        System.out.println("----------------------------------------------------------------");
        System.out.println("@Autowired by Constructor. Employee Name=" + autowiredByConstructorService.getEmployee().getName());

        ctx.close();
    }
}

