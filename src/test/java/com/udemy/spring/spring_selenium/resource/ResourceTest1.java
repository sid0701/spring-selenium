package com.udemy.spring.spring_selenium.resource;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest1 extends SpringBaseTestNGTest {

    @Value("classpath:data/testdata1.csv")
    private Resource resource1;

    @Value("file:C:\\Users\\DELL\\OneDrive\\Desktop\\Core Java\\02-CodeWithVinoth\\spring-selenium\\spring-selenium\\src\\test\\resources\\data\\testdata1.csv")
    private Resource resource2;

    @Value("https://google.com")
    private Resource resource3;

    @Value("https://www.w3.org/TR/png-3/#bib-iso_8859-1.txt")
    private Resource resource4;

    @Value("${screenshot.path}/some.txt")
    private Path path;

    @Test
    public void readFile() throws IOException {

        System.out.println("Resource 1 -----");
        Files.readAllLines(resource1.getFile().toPath())
                        .forEach(System.out::println);

        System.out.println("Resource 2 -----");
        Files.readAllLines(resource2.getFile().toPath())
                        .forEach(System.out::println);

        System.out.println("Resource 3 -----");
        System.out.println(
                new String(resource3.getInputStream().readAllBytes())
        );

        System.out.println("Resource 4 -----");
        System.out.println(
                new String(resource4.getInputStream().readAllBytes())
        );

        FileCopyUtils.copy(resource4.getInputStream(), Files.newOutputStream(path));


    }

}
