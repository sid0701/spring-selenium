package com.udemy.spring.spring_selenium.practise_tests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import com.udemy.spring.spring_selenium.practise.MyTelevision;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

public class TelevisionPractiseTest extends SpringBaseTestNGTest {

    @Autowired
    private MyTelevision tv;

    @Autowired
    private List<String> mylist;

    @Test
    public void playMovieTest()
    {
        this.tv.playMovie();
        System.out.println(this.mylist);

    }

}
