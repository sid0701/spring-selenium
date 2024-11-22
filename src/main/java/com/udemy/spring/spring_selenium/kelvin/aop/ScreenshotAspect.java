package com.udemy.spring.spring_selenium.kelvin.aop;

import com.github.javafaker.Faker;
import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import com.udemy.spring.spring_selenium.kelvin.annotations.TakeScreenshot;
import com.udemy.spring.spring_selenium.kelvin.annotations.TakeScreenshotBDD;
import com.udemy.spring.spring_selenium.kelvin.service.ScreenshotService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenshotService screenshotService;

    @After("@annotation(screenshot)")
    public void takeScreenshot(TakeScreenshot screenshot) throws IOException {
        Faker faker = new Faker();
        screenshotService.takesScreenshot(faker.name().firstName());
    }

    @After("@annotation(screenshot)")
    public void takeScreenshotBDD(TakeScreenshotBDD screenshot) throws IOException {
        Faker faker = new Faker();
        screenshotService.takesScreenshot(faker.name().firstName());
    }



}
