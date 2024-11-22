package com.udemy.spring.spring_selenium.google_project.main;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.google_project.confirmation.ConfirmationPage;
import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

@Page
public class GoogleMainPage extends AbstractComponent {

    private static final Logger logger = LoggerFactory.getLogger(GoogleMainPage.class);

    @LazyAutowired
    private SearchWidget searchWidget;

    @LazyAutowired
    private SearchSuggestions searchSuggestions;

    @LazyAutowired
    private ConfirmationPage confirmationComponent;

    @Value("${application.url}")
    String url;

    public void goTo(){
        this.driver.get(url);
        if(this.confirmationComponent.isDisplayed()){
            logger.debug("The language button has been displayed");
            this.confirmationComponent.clickOnAccept();
        }

    }

    public SearchWidget getSearchWidget() {
        return this.searchWidget;
    }

    public SearchSuggestions getSearchSuggestions() {
        return this.searchSuggestions;
    }

    @Override
    public boolean isDisplayed() {
        return searchWidget.isDisplayed();
    }

    public void quitBrowser(){
        this.driver.quit();
    }
}
