package com.udemy.spring.spring_selenium.kelvin.config;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyConfiguration;
import com.udemy.spring.spring_selenium.kelvin.annotations.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

    @Value("${driver.version}")
    private String driverVersion;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver getChromeWebDriver() {
        WebDriverManager.chromedriver().driverVersion(this.driverVersion).setup();
//        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
        return new ChromeDriver();
    }



}
