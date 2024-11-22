package com.udemy.spring.spring_selenium.google_project.confirmation;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Page
public class ConfirmationPage extends AbstractComponent {

    @FindBy(xpath = "//button[contains(@aria-label,'Taal')]")
    private WebElement languageBttn;

    @FindBy(xpath = "//button/div[text()='Alles accepteren']")
    private WebElement acceptBttn;

    public void clickOnAccept(){
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", this.acceptBttn);
        actions.scrollToElement(this.acceptBttn).build().perform();
        this.acceptBttn.click();
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(this.languageBttn);
    }
}
