package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//Use appropriate annotation to scan the packages
@ComponentScan(basePackages = {"com.controller", "com.service", "com.model"})
public class CollegesListApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegesListApplication.class,args);
	}

}