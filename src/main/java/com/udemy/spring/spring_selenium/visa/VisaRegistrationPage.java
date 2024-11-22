package com.udemy.spring.spring_selenium.visa;

import com.udemy.spring.spring_selenium.common_components.AbstractComponent;
import com.udemy.spring.spring_selenium.kelvin.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Page
public class VisaRegistrationPage extends AbstractComponent {

    private static final Logger logger = LoggerFactory.getLogger(VisaRegistrationPage.class);

    @FindBy(id = "first_4")
    private WebElement firstName;

    @FindBy(id = "last_4")
    private WebElement lastName;

    @FindBy(id = "input_46")
    private WebElement fromCountry;

    @FindBy(id = "input_47")
    private WebElement toCountry;

    @FindBy(id = "input_24_month")
    private WebElement month;

    @FindBy(id = "input_24_day")
    private WebElement day;

    @FindBy(id = "input_24_year")
    private WebElement year;

    @FindBy(id = "input_6")
    private WebElement email;

    @FindBy(id = "input_27_phone")
    private WebElement phone;

    @FindBy(id = "input_45")
    private WebElement comments;

    @FindBy(id = "submitBtn")
    private WebElement submitBtn;

    @FindBy(id = "requestnumber")
    private WebElement requestNo;

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");
    }

    public void setName(final String firstName, final String lastName){
        logger.info("Getting Names : "+firstName);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
    }

    public void setCountry(final String countryFrom, final String countryTo){
        new Select(this.fromCountry).selectByValue(countryFrom);
        new Select(this.toCountry).selectByValue(countryTo);
    }

    public void setDob(final LocalDate dateOfBirth){
        new Select(this.month).selectByValue(String.valueOf(dateOfBirth.getMonth()));
        new Select(this.day).selectByValue(String.valueOf(dateOfBirth.getDayOfMonth()));
        new Select(this.year).selectByValue(String.valueOf(dateOfBirth.getYear()));
    }

    public void setEmail(String emailAdd){
        this.email.sendKeys(emailAdd);
    }

    public void setMobileNo(String phoneNo){
        this.phone.sendKeys(phoneNo);
    }

    public void setComments(String comments){
        this.comments.sendKeys(Objects.toString(comments,""));
    }

    public void submit(){
        this.submitBtn.click();
    }

    public String getRequestNo(){
        this.wait.until((d) -> this.requestNo.isDisplayed());
        return this.requestNo.getText();
    }

    public void close(){
        this.driver.quit();
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed(this.firstName);
    }
}
