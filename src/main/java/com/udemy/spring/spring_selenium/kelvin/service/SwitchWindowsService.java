package com.udemy.spring.spring_selenium.kelvin.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SwitchWindowsService {

    @Autowired
    private ApplicationContext ctx;

    public void switchWindowByTitle(String title) {

        WebDriver driver = ctx.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(t -> t.equals(title))
                .findFirst()
                .orElseThrow(
                        () -> {
                            return new RuntimeException("Window not found: " + title);
                        }
                );

    }

    public void switchWindowByIndex(int index) {
        WebDriver driver = ctx.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }

}
