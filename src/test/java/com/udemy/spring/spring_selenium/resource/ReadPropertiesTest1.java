package com.udemy.spring.spring_selenium.resource;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesTest1 extends SpringBaseTestNGTest {


    @Autowired
    ResourceLoader resourceLoader;

    @Test
    public void readMyProperties() throws IOException {

        Properties properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("my.properties"));
        System.out.println(properties);
    }

}
