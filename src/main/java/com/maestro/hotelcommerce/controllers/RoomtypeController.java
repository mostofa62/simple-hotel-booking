package com.maestro.hotelcommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maestro.hotelcommerce.models.Hotel;
import com.maestro.hotelcommerce.models.RoomType;
import com.maestro.hotelcommerce.models.cores.User;
import com.maestro.hotelcommerce.repositories.HotelRepository;
import com.maestro.hotelcommerce.repositories.RoomTypeRepository;
import com.maestro.hotelcommerce.repositories.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/roomtype")
public class RoomtypeController {

	@Autowired
	private RoomTypeRepository roomtypeRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("name", "Golam Mostofa");
		return "roomtype/index";
	}
	
	@GetMapping("/create")
	public String create(ModelMap model) {
		RoomType roomType = new RoomType();
		List<Hotel> hotels = hotelRepository.findAll();
		
		
		
		
		model.addAttribute("roomType", roomType);
		model.addAttribute("hotels", hotels);
		
		
		
		return "roomtype/create";
	}
	
	
	@PostMapping("/create")
	public String store(
			@ModelAttribute @Validated RoomType roomType,
			BindingResult bindingResult,
			ModelMap model
			) {
			
			List<Hotel> hotels = hotelRepository.findAll();
			model.addAttribute("hotels", hotels);
			if(bindingResult.hasErrors()) {
				
				
				return "roomtype/create";
			}
			
			// this will come by login user just now for dummy testing
			long idLong=1;		
			User user = userRepository.findById(idLong).orElseThrow(()-> new IllegalArgumentException("Not Found"+idLong));
			//end dummy testing
			
			roomType.setRtuser(user); 
			
			roomtypeRepository.save(roomType);
			
			return "redirect:/roomtype";
		
	}
	
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable Long id, ModelMap model) {
		RoomType roomType = roomtypeRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Invalid id"+id));
		List<Hotel> hotels = hotelRepository.findAll();
		
		model.addAttribute("roomType", roomType);
		model.addAttribute("hotels", hotels);
		
		
		return "roomtype/update";
	}
	
	@PostMapping("/update/{id}")
	public String update(
			@ModelAttribute @Validated RoomType roomType,
			BindingResult bindingResult,
			@PathVariable Long id,
			ModelMap model
			) {
		
			List<Hotel> hotels = hotelRepository.findAll();
			model.addAttribute("hotels", hotels);
		
			if(bindingResult.hasErrors()) {
			return "roomtype/update";
			}
			
			roomtypeRepository.save(roomType);
			
			return "redirect:/roomtype";
	}
}
