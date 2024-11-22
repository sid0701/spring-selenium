package com.udemy.spring.spring_selenium.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@ConditionalOnExpression("${car.speed:75} >= 70")
public class Accord implements Car{

    @Override
    public void run() {
        System.out.println("I am Accord, I can run at 80 mph..");
    }
}
