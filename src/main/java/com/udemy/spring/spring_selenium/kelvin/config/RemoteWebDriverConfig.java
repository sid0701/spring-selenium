package com.udemy.spring.spring_selenium.kelvin.config;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyConfiguration;
import com.udemy.spring.spring_selenium.kelvin.annotations.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {

    @Value("${grid.url}")
    private URL gridUrl;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver getRemoteFirefoxWebDriver() {
        return new RemoteWebDriver(this.gridUrl, new FirefoxOptions());
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver getRemoteChromeWebDriver() {
        return new RemoteWebDriver(this.gridUrl, new ChromeOptions());
    }

}
