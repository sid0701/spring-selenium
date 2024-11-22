package com.udemy.spring.spring_selenium.kelvin.config;

import com.github.javafaker.Faker;
import com.udemy.spring.spring_selenium.kelvin.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker returnFaker(){
        return new Faker();
    }

}
