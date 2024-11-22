package com.udemy.spring.spring_selenium.kelvin.service;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class DriverFactory {

    public WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else
            return new FirefoxDriver();
    }

}
