package com.maestro.hotelcommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maestro.hotelcommerce.models.Hotel;
import com.maestro.hotelcommerce.repositories.HotelRepository;



@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	
	@GetMapping("")
	public @ResponseBody List<Hotel> index() {
		
		List<Hotel> hotels = hotelRepository.findAll();
		return hotels;
	}
	
	
	@PostMapping("/create")
	public @ResponseBody Hotel create(
			@ModelAttribute @Validated Hotel hotel,
			BindingResult bindingResult
			
			){
		
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getGlobalErrors());
			
			return hotel;
		}
		
		SetHotelChild(hotel);
		hotelRepository.save(hotel);
		return hotel;
	}
	
	
	
	
	@PostMapping("/edit/{id}")
	public @ResponseBody Hotel edit(
			@ModelAttribute @Validated Hotel hotel,
			BindingResult bindingResult,
			@PathVariable Long id) {
		
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getGlobalErrors());
			return hotel;
		}
		
		SetHotelChild(hotel);
		hotelRepository.save(hotel);				
		return hotel;
		
	}
	
	/**
	 * 
	 * Non Controller Functions
	 */
	
	private void SetHotelChild(Hotel hotel) {
		
		Long parentId = hotel.getParentId();
		
		if( parentId != null ) {
			Hotel parentHotel = hotelRepository.getOne(parentId);
			hotel.setHotel(parentHotel);
		}	
	}
	
	
	
	
	
	

}
