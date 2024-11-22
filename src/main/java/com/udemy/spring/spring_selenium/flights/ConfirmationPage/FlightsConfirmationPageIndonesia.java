package com.udemy.spring.spring_selenium.flights.ConfirmationPage;

import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class FlightsConfirmationPageIndonesia extends FlightsConfirmationPage {

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[text()='Terima semua']")
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
