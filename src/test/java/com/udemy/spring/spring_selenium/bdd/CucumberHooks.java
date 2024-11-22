package com.udemy.spring.spring_selenium.bdd;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import com.udemy.spring.spring_selenium.kelvin.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext context;

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed())
            scenario.attach(this.screenshotService.getScreenshotAsBytes(),"image/png",scenario.getName());
    }

    @After
    public void afterScenario(){
        this.context.getBean(WebDriver.class).quit();
    }

}
