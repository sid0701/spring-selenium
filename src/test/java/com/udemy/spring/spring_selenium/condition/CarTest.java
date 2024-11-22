package com.udemy.spring.spring_selenium.condition;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Test;

public class CarTest extends SpringBaseTestNGTest {

    @Lazy
    @Autowired
    private Car car;

    @Test
    public void test(){
        car.run();
    }

}
