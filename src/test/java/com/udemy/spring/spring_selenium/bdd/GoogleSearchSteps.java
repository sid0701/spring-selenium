package com.udemy.spring.spring_selenium.bdd;

import com.udemy.spring.spring_selenium.google_project.main.GoogleMainPage;
import com.udemy.spring.spring_selenium.google_project.results.GoogleResultsPage;
import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import com.udemy.spring.spring_selenium.kelvin.annotations.TakeScreenshot;
import com.udemy.spring.spring_selenium.kelvin.annotations.TakeScreenshotBDD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@CucumberContextConfiguration
@SpringBootTest
public class GoogleSearchSteps {

        private static final Logger logger = LoggerFactory.getLogger(GoogleSearchSteps.class);

        @LazyAutowired
        private GoogleMainPage googleMainPage;

        @LazyAutowired
        private GoogleResultsPage googleResultsPage;

        @Given("^I am on google home page$")
        public void launchSite(){
                this.googleMainPage.goTo();
        }

        @When("^I enter \"([^\"]*)\" as a keyword$")
        public void searchKeyword(String keyword){
                logger.warn("Search Box is displayed for my "+keyword+" : "+this.googleMainPage.getSearchWidget().isDisplayed());
                this.googleMainPage.getSearchWidget().search(keyword);
                Assert.assertTrue(this.googleMainPage.getSearchWidget().isDisplayed());
                this.googleMainPage.getSearchSuggestions().selectSuggestion(1);
        }


        @Then("^I should see at least ([^\"]*) results$")
        @TakeScreenshotBDD
        public void verifyResult(int count){
                        this.googleResultsPage.getResultStats().isDisplayed();
                        Assert.assertTrue(this.googleResultsPage.getResultStats().count() > count);
                }

}
