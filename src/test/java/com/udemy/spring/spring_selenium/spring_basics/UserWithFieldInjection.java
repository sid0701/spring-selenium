package com.udemy.spring.spring_selenium.spring_basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class UserWithFieldInjection {

    @Lazy
    @Autowired
    private Address address;

    @Lazy
    @Autowired
    private Salary salary;

    public void printDetails(){
        System.out.println("Salary : "+this.salary.getSalary());
        System.out.println("Address : "+this.address.getStreet());
    }

}
