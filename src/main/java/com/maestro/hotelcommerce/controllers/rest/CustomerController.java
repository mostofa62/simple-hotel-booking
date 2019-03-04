package com.maestro.hotelcommerce.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maestro.hotelcommerce.models.Customer;
import com.maestro.hotelcommerce.repositories.rest.CustomerRepository;


@RestController("rest CustomerController")
@RequestMapping("/api")
public class CustomerController {

	@Autowired	
	private  CustomerRepository customerRestRepository;
	
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public DataTablesOutput<Customer> getUsers(@Valid DataTablesInput input){
		return customerRestRepository.findAll(input);
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public DataTablesOutput<Customer> getBypostUsers(@Valid @RequestBody DataTablesInput input){
		return customerRestRepository.findAll(input);
	}
	
	
	
}
	