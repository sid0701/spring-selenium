package com.udemy.spring.spring_selenium.flights.ConfirmationPage;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public abstract class FlightsConfirmationPage extends AbstractComponent {

    public abstract void acceptAll();
    public abstract boolean isDisplayed();

    public void acceptAll(WebElement acceptBttn){
        //js.executeScript("arguments[0].scrollIntoView(true);", acceptBttn);
        actions.scrollToElement(acceptBttn).build().perform();
        acceptBttn.click();
    }

}