package com.udemy.spring.spring_selenium.spring_basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class UserWithSetterInjection {

    private Address address;
    private Salary salary;

    @Lazy
    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Lazy
    @Autowired
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public void printDetails(){
        System.out.println("Salary : "+this.salary.getSalary());
        System.out.println("Address : "+this.address.getStreet());
    }

}
