package com.udemy.spring.spring_selenium.flights.ConfirmationPage;

import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class FlightsConfirmationPageEnglish extends FlightsConfirmationPage {

    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[text()='Accept all']")
    private WebElement acceptBttn;


    @Override
    public void acceptAll(){
        super.acceptAll(acceptBttn);
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(signInButton);
    }
}
