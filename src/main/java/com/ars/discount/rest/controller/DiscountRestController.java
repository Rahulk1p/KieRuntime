package com.ars.discount.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ars.discount.service.DiscountService;
import com.myspace.discount.Customer;

@RestController
public class DiscountRestController {

	@Autowired
	private DiscountService service;

	@PostMapping(path = "MyCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getDiscount(@RequestBody Customer customer) {
		System.out.println("incoming customer = " + customer);
		Customer cust = null;
		cust = service.getDiscount(customer);
		System.out.println(cust);
		return new ResponseEntity<>(cust, HttpStatus.CREATED);
	}

	@PostMapping(path = "MyCustomerTest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getDiscountTest(@RequestBody Customer customer) {
		System.out.println("incoming customer = " + customer);
		Customer cust = null;
		for (int i = 1; i <= 1200000; i++) {
			cust = service.getDiscount(customer);
			System.out.println(cust);
		}
		return new ResponseEntity<>(cust, HttpStatus.CREATED);
	}

}
