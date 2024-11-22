package com.udemy.spring.spring_selenium.practise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ListOfStringConfig {

    @Bean
    public List<String> getList(){
        return List.of("a","b","c");
    }

}