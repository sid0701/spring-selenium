package com.udemy.spring.spring_selenium.flights;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.flights.ConfirmationPage.FlightConfirmationPageFactory;
import com.udemy.spring.spring_selenium.flights.ConfirmationPage.FlightsConfirmationPage;
import com.udemy.spring.spring_selenium.flights.ConfirmationPage.FlightsConfirmationPageEnglish;
import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import com.udemy.spring.spring_selenium.kelvin.annotations.TakeScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightsPage extends AbstractComponent {

    @Autowired
    private ApplicationContext applicationContext;

    private FlightsConfirmationPage confirmationPage;

    @FindBy(css = "nav.P6Wwdb.OE019d div span")
    private List<WebElement> labels;

    public void goTo(final String url){
        this.driver.get(url);
        String language = url.split("=")[1];

        switch (language.toUpperCase()){
            case "EN" :
                confirmationPage = applicationContext.getBean("getEnglishConfirmationPage", FlightsConfirmationPage.class);
                break;
            case "ID" :
                confirmationPage = applicationContext.getBean("getIndonesianConfirmationPage", FlightsConfirmationPage.class);
                break;
        }

        if(this.confirmationPage.isDisplayed())
            this.confirmationPage.acceptAll();
    }

    public void quit(){
        this.driver.quit();
    }

    @TakeScreenshot
    public List<String> getLabels(){

        return this.labels.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(this.labels);
    }
}
