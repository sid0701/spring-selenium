package com.udemy.spring.spring_selenium.google_project_tests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import com.udemy.spring.spring_selenium.google_project.main.GoogleMainPage;
import com.udemy.spring.spring_selenium.google_project.results.GoogleResultsPage;
import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import com.udemy.spring.spring_selenium.kelvin.service.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleWorkflowTest1 extends SpringBaseTestNGTest {

    @LazyAutowired
    private GoogleMainPage googleMainPage;

    @LazyAutowired
    private GoogleResultsPage googleResultsPage;

    @LazyAutowired
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
                {"Java",2},
                {"AWS",1}
        };
    }

    @AfterTest
    public void afterTest(){
        this.googleMainPage.quitBrowser();
    }

}
