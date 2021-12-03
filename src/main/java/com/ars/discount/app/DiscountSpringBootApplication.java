package com.ars.discount.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ars.discount.rest.controller","com.ars.discount.service","com.ars.discount.model"})
public class DiscountSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountSpringBootApplication.class, args);
	}

}
