package com.udemy.spring.spring_selenium.practise;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class MyTelevision {

    @Value("${tv.name:sony}")
    private String name;

    public MyTelevision(){
        System.out.println("Inside conctructor : "+this.name);
    }

    @PostConstruct
    private void init(){
        System.out.println("Inside Post Construct : "+this.name);
        System.out.println("TV is turned on..");
    }

    public void playMovie(){
        for(int i=1;i<5;i++){
            System.out.println("Playing part : "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PreDestroy
    public void turnOff(){
        System.out.println("TV is turned off..");
    }

}
