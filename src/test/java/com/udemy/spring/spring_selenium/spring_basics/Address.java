package com.udemy.spring.spring_selenium.spring_basics;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Address {

    @Lazy
    @Autowired
    private Faker faker;

    public String getStreet() {
        return this.faker.address().streetAddress();
    }
}
