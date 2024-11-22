package com.udemy.spring.spring_selenium.spring_basics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

@SpringBootTest
class SeleniumApplicationTestsWithSpring2 {

	@Lazy
	@Autowired
	private Television tv;

	@Test
	void contextLoads() {

		tv.watchMovie();

	}

}
