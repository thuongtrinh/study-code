package com.txt.spring.autowiring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.txt.spring.autowiring.model.Employee;

public class EmployeeAutowiredByTypeService {

    //Autowired annotation on variable/setters is equivalent to autowire="byType"
    @Autowired
    private Employee employee;

    /*@Autowired*/
    public void setEmployee(Employee emp) {
        System.out.println("EmployeeAutowiredByTypeService: setEmployee " + emp.getName());
        this.employee = emp;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
