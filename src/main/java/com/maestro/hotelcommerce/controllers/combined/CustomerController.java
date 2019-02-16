package com.maestro.hotelcommerce.controllers.combined;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maestro.hotelcommerce.models.Address;
import com.maestro.hotelcommerce.models.Customer;
import com.maestro.hotelcommerce.repositories.CustomerRepository;
import com.maestro.hotelcommerce.util.Title;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@GetMapping("")
	private String Index() {
		return "redirect:/customer/create";
	}
	

	@GetMapping("/create")
	public String create(ModelMap model) {
		
		Customer customer = new Customer();
		
		customer.setAddress(new Address());
		
		List<Title> titles = new ArrayList<Title>( Arrays.asList(Title.values() ));
		model.addAttribute("titles", titles);
		model.addAttribute("customer",customer);
		return "customer/create";
	}
	
	@PostMapping("/create")
	public String store(
			@ModelAttribute @Validated Customer customer,			
			BindingResult bindingResult,
			ModelMap model
			) {
	
			if(bindingResult.hasErrors()) {
				
				List<Title> titles = new ArrayList<Title>( Arrays.asList(Title.values() ));
				model.addAttribute("titles", titles);
				
				return "customer/create";
			}
			
			
			customerRepository.save(customer);
			
			return "redirect:/customer/create";
		
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable Long id, ModelMap model) {
		
		Customer customer = customerRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("Not Found with this ID: "+id));
		
		List<Title> titles = new ArrayList<Title>( Arrays.asList(Title.values() ));
		model.addAttribute("titles", titles);
		model.addAttribute("customer",customer);
		
		return "customer/update";
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute @Validated Customer customer,			
			BindingResult bindingResult,
			@PathVariable Long id,
			ModelMap model) {
		
		
			if(bindingResult.hasErrors()) {
				
				List<Title> titles = new ArrayList<Title>( Arrays.asList(Title.values() ));
				model.addAttribute("titles", titles);
				
				return "customer/update";
			}
		
		
		customerRepository.save(customer);
		
		return "redirect:/customer/create";
		
	}
	
}
