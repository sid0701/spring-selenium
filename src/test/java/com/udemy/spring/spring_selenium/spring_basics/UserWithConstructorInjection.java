package com.udemy.spring.spring_selenium.spring_basics;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class UserWithConstructorInjection {

    private Address address;
    private Salary salary;

    public UserWithConstructorInjection(Address address, Salary salary) {
        this.address = address;
        this.salary = salary;
    }

    public void printDetails(){
        System.out.println("Salary : "+this.salary.getSalary());
        System.out.println("Address : "+this.address.getStreet());
    }

}
