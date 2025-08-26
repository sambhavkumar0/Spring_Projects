package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//use appropriate annotation to scan all the packages
@SpringBootApplication
@ComponentScan(basePackages = {"com.controller", "com.service", "com.model"})
public class SwiftCartPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftCartPortalApplication.class,args);
	}

}