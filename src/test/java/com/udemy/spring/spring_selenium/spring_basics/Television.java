package com.udemy.spring.spring_selenium.spring_basics;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Television {

    @Value("${tv.name:sony}")
    private String name;

    public Television() {
        System.out.println("Inside the constructor of Television... "+this.name);
    }

    @PostConstruct
    private void init(){
        System.out.println("Inside the init method used by bean... "+this.name);
        System.out.println("TV is turned on!!");
    }

    public void watchMovie(){
        for (var i=1;i<6;i++){
            System.out.println("Watching Part : "+i);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @PreDestroy
    private void turnOff(){
        System.out.println("TV turned off...");
    }

}
