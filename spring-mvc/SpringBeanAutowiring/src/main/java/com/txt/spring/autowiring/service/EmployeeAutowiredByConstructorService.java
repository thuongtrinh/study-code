package com.txt.spring.autowiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.txt.spring.autowiring.model.Employee;

public class EmployeeAutowiredByConstructorService {

    private Employee employee;

    // Autowired annotation on Constructor is equivalent to autowire="constructor"
    @Autowired(required = false)
    public EmployeeAutowiredByConstructorService(@Qualifier("employee") Employee emp) {
        System.out.println("EmployeeAutowiredByConstructorService: " + emp.getName());
        this.employee = emp;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
