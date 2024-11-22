package com.udemy.spring.spring_selenium.visa_tests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import com.udemy.spring.spring_selenium.entity.Customer;
import com.udemy.spring.spring_selenium.repository.CustomerRepository;
import com.udemy.spring.spring_selenium.visa.VisaRegistrationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class VisaRegistrationTest extends SpringBaseTestNGTest {

    private static final Logger logger = LoggerFactory.getLogger(VisaRegistrationTest.class);

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Test(dataProvider = "getData")
    public void visaTest(Customer c){

            this.registrationPage.goTo();
            this.registrationPage.setName(c.getFirstName(),c.getLastName());
            this.registrationPage.setCountry(c.getFromCountry(),c.getToCountry());
            this.registrationPage.setDob(c.getDob().toLocalDate());
            this.registrationPage.setEmail(c.getEmail());
            this.registrationPage.setMobileNo(c.getPhone());
            this.registrationPage.setComments(c.getComments());
            this.registrationPage.submit();

            logger.info("Request confirmation # INFO : "+this.registrationPage.getRequestNo());
            logger.warn("Request confirmation # WARN : "+this.registrationPage.getRequestNo());

    }

    @DataProvider
    public Object[] getData(ITestContext context){
        return this.repository
                        .findByDobBetween(
                                Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                                Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo")))
                        .stream()
                        .limit(3)
                        .toArray();
    }

    @AfterTest
    public void tearDown(){
        this.registrationPage.close();
    }

}
