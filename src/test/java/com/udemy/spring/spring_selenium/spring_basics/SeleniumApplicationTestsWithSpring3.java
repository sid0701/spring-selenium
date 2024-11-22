package com.udemy.spring.spring_selenium.spring_basics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@SpringBootTest
class SeleniumApplicationTestsWithSpring3 {

	@Lazy
	@Autowired
	private List<String> str;

	@Test
	void contextLoads() {

		System.out.println(str);


	}

}
