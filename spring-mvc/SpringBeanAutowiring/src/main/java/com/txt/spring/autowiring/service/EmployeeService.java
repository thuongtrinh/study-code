package com.txt.spring.autowiring.service;

import com.txt.spring.autowiring.model.Employee;

public class EmployeeService {

    private Employee employee;

    // constructor is used for autowiring by constructor
    public EmployeeService(Employee emp) {
        System.out.println("EmployeeService: Autowiring by constructor used");
        this.employee = emp;
    }

    // default constructor to avoid BeanInstantiationException for autowiring byName or byType
    public EmployeeService() {
        System.out.println("EmployeeService: Default Constructor used");
    }

    // used for autowire byName and byType
    public void setEmployee(Employee emp) {
        System.out.println("EmployeeService: setEmployee " + emp.getName());
        this.employee = emp;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
