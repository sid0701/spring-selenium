package com.udemy.spring.spring_selenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.udemy.spring.spring_selenium.bdd",
        tags = "@google",
        plugin = {
                "pretty",
                "html:C:\\Users\\DELL\\OneDrive\\Desktop\\Core Java\\02-CodeWithVinoth\\spring-selenium\\spring-selenium\\Cucumber-Results\\report.html"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {


        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
