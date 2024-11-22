package com.udemy.spring.spring_selenium.bdd;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import com.udemy.spring.spring_selenium.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

public class VisaRegistrationSteps {

        @LazyAutowired
        private VisaRegistrationPage visaRegistrationPage;

        @Given("^I am on the Visa Registration Page$")
        public void launchSite(){
                this.visaRegistrationPage.goTo();
                this.visaRegistrationPage.isDisplayed();
        }

        @When("^I enter my \"([^\"]*)\" and \"([^\"]*)\"$")
        public void enterName(String firstName, String lastName){
                this.visaRegistrationPage.setName(firstName,lastName);
        }

        @And("^I select my from country \"([^\"]*)\" and to country \"([^\"]*)\"$")
        public void selectCountry(String fromCountry, String toCountry){
                this.visaRegistrationPage.setCountry(fromCountry, toCountry);
        }

        @And("^I enter my date of birth \\\"([^\\\"]*)\\\"$")
        public void selectDateOfBirth(String dob){
                this.visaRegistrationPage.setDob(Date.valueOf(dob).toLocalDate());
        }

        @And("^I enter my email id \"([^\"]*)\"$")
        public void enterEmailId(String emailId){
                this.visaRegistrationPage.setEmail(emailId);
        }

        @And("^I enter my mobile no \"([^\"]*)\"$")
        public void enterMobileNo(String mobileNo){
                this.visaRegistrationPage.setMobileNo(mobileNo);
        }

        @And("^I enter comments \"([^\"]*)\"$")
        public void enterComments(String comments){
                this.visaRegistrationPage.setComments(comments);
        }

        @And("^I submit the form$")
        public void submitForm(){
                this.visaRegistrationPage.submit();
        }

        @Then("^I should get a Registration Number$")
        public void getRegistrationNumber(){
                System.out.println("Registration No : "+this.visaRegistrationPage.getRequestNo());
        }
}
