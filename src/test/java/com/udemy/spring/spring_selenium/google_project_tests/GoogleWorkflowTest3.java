package com.udemy.spring.spring_selenium.google_project_tests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import com.udemy.spring.spring_selenium.google_project.main.GoogleMainPage;
import com.udemy.spring.spring_selenium.google_project.results.GoogleResultsPage;
import com.udemy.spring.spring_selenium.kelvin.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleWorkflowTest3 extends SpringBaseTestNGTest {

    @Lazy
    @Autowired
    private GoogleMainPage googleMainPage;

    @Lazy
    @Autowired
    private GoogleResultsPage googleResultsPage;

    @Lazy
    @Autowired
    private ScreenshotService screenShotService;

    @Test(dataProvider = "provideData")
    public void googleWF(String keyword, int index) throws IOException {

        this.googleMainPage.goTo();
        Assert.assertTrue(this.googleMainPage.isDisplayed());
        this.googleMainPage.getSearchWidget().search(keyword);
        Assert.assertTrue(this.googleMainPage.getSearchSuggestions().isDisplayed());
        this.googleMainPage.getSearchSuggestions().selectSuggestion(index);

//      Assert.assertTrue(this.googleResultsPage.isDisplayed());
        this.googleResultsPage.getNavigationBar().clickOnVideosTab();
        System.out.println("Videos Result "+keyword+" : "+this.googleResultsPage.getResultStats().getResult());

        this.googleResultsPage.getNavigationBar().clickOnNewsTab();
        System.out.println("News Result for "+keyword+" : "+this.googleResultsPage.getResultStats().getResult());

        screenShotService.takesScreenshot(keyword);

    }

    @DataProvider(name="provideData")
    public Object[][] getData(){
        return new Object[][]{
                {"Selenium",2},
                {"Kubernetes",1}
        };
    }

    @AfterTest
    public void afterTest(){
        this.googleMainPage.quitBrowser();
    }

}
