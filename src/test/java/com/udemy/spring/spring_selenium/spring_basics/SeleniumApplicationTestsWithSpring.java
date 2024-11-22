package com.udemy.spring.spring_selenium.spring_basics;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@SpringBootTest
class SeleniumApplicationTestsWithSpring {

//	@Autowired
//	private UserWithConstructorInjection user1;
//
//	@Autowired
//	private UserWithSetterInjection user2;
//
	@Lazy
	@Autowired
	private UserWithFieldInjection user3;

//	@Value("${PATH}")
//	private String path;

	@Value("${fruit}")
	private List<String> fruit;

	@Value("${timeout}")
	private int timeout;

	@Value("${myusername}")
	private String username;

	//Here the default value https://google.com will only be used if the value for TEST_URL is not available in the application.properties file
	@Value("${TEST_URL:https://google.com}")
	String test_url;

	@Lazy
	@Autowired
	private Faker faker;

	@Test
	void contextLoads() {

//		user1.printDetails();
//		user2.printDetails();
		user3.printDetails();

//		System.out.println("Path : "+this.path);
		System.out.println("Fruit : "+this.fruit);
		System.out.println("Size : "+this.fruit.size());
		System.out.println("Timeout : "+this.timeout);
		System.out.println("My username : "+this.username);
		System.out.println("Test URL : "+this.test_url);

//		Faker faker = new Faker();
		System.out.println("First Fake Name : "+faker.name().firstName());


	}

}
