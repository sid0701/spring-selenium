package com.udemy.spring.spring_selenium.kelvin.aop;

import com.udemy.spring.spring_selenium.kelvin.annotations.Window;
import com.udemy.spring.spring_selenium.kelvin.service.SwitchWindowsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private SwitchWindowsService switchWindowsService;

    @Before("@target(window) && within(com.udemy.spring.spring_selenium..*)")
    public void switchWindows(Window window) {
        switchWindowsService.switchWindowByTitle(window.value());
    }

    @After("@target(window) && within(com.udemy.spring.spring_selenium..*)")
    public void switchToMain(){
        switchWindowsService.switchWindowByIndex(0);
    }

}
