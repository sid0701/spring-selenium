package com.udemy.spring.spring_selenium.spring_basics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Salary {

    @Value("${salary:500}")
    private int salary;

    public int getSalary() {
        return salary;
    }
}
