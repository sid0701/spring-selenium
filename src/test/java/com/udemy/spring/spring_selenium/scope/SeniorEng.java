package com.udemy.spring.spring_selenium.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SeniorEng {

    @Autowired
    private EngSalary salary;

    public void setSalary(int amount) {
        this.salary.setAmount(amount);
    }

    public int getSalary() {
        return this.salary.getAmount();

    }

}
