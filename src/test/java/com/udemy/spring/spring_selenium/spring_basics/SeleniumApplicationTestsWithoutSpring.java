package com.udemy.spring.spring_selenium.spring_basics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeleniumApplicationTestsWithoutSpring {

	@Test
	void contextLoads() {

		var address = new Address();
		var salary = new Salary();
		var user = new UserWithConstructorInjection(address,salary);

		user.printDetails();


	}

}
