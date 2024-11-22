package com.udemy.spring.spring_selenium.flights_project_tests;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyComponent;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@LazyComponent
@PropertySource("labels/${app.locale}.properties")
public class FlightApplicationDetails {

    @Value("${flight.app.url}")
    private String url;

    @Value("${flight.app.labels}")
    private List<String> labels;

    public String getUrl(){
        return this.url;
    }

    public List<String> getLabels(){
        return this.labels;
    }
}
