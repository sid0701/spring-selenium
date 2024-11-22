package com.udemy.spring.spring_selenium.flights_project_tests;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=id", "browser=firefox"})
public class FlightsIDTest extends FlightTests{
}
