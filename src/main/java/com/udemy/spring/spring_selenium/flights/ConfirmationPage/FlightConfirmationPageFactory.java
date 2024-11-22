package com.udemy.spring.spring_selenium.flights.ConfirmationPage;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@LazyComponent
public class FlightConfirmationPageFactory {

    @Bean
    public FlightsConfirmationPage getEnglishConfirmationPage(){
        return new FlightsConfirmationPageEnglish();
    }

    @Bean
    public FlightsConfirmationPage getIndonesianConfirmationPage(){
        return new FlightsConfirmationPageIndonesia();
    }

}
