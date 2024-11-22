package com.udemy.spring.spring_selenium.kelvin.config;

import com.udemy.spring.spring_selenium.kelvin.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@LazyConfiguration
public class ListConfig {

    @Bean
    public List<Integer> returnString(){
        return List.of(1,2,21,7);
    }

}
