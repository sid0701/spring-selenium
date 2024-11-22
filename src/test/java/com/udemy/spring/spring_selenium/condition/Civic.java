package com.udemy.spring.spring_selenium.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@ConditionalOnExpression("${car.speed:75} < 70")
public class Civic implements Car{

    @Override
    public void run() {
        System.out.println("I am Civic, I can run at 60 mph..");
    }
}
