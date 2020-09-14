package com.dk.lcs.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dk.lcs.service.cotroller.LCSController;

@SpringBootApplication
@ComponentScan(basePackageClasses = LCSController.class)
public class StringProcessorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringProcessorServiceApplication.class, args);
	}

}
