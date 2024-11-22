package com.udemy.spring.spring_selenium.scope;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Test;

public class JuniorSeniorTest extends SpringBaseTestNGTest {

    @Lazy
    @Autowired
    private JuniorEng juniorEng;

    @Lazy
    @Autowired
    private SeniorEng seniorEng;

    @Test
    public void testScope() {

        this.juniorEng.setSalary(100);
        System.out.println("Junior : "+this.juniorEng.getSalary());

        this.seniorEng.setSalary(200);
        System.out.println("Senior : "+this.seniorEng.getSalary());

        System.out.println("Junior : "+this.juniorEng.getSalary());

    }




}
