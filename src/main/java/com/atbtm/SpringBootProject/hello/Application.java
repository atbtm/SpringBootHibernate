package com.atbtm.SpringBootProject.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atbtm.SpringBootProject.hello.properties.BlogProperties;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		SpringApplication.run(Application.class, args);
		
	}

}

