package com.udemy.spring.spring_selenium.flights_project_tests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import com.udemy.spring.spring_selenium.flights.FlightsPage;
import com.udemy.spring.spring_selenium.kelvin.annotations.LazyAutowired;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FlightTests extends SpringBaseTestNGTest {

    @LazyAutowired
    private FlightApplicationDetails applicationDetails;

    @LazyAutowired
    private FlightsPage flightsPage;

    @Test
    public void testLabels(){

        this.flightsPage.goTo(this.applicationDetails.getUrl());
        Assert.assertTrue(this.flightsPage.isDisplayed());
        Assert.assertEquals(this.flightsPage.getLabels(),this.applicationDetails.getLabels());

    }

    @AfterTest
    public void tearDown(){
        this.flightsPage.quit();
    }

}
