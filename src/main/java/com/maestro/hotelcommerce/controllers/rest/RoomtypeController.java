package com.maestro.hotelcommerce.controllers.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maestro.hotelcommerce.models.Hotel;
import com.maestro.hotelcommerce.repositories.RoomTypeRepository;
import com.maestro.hotelcommerce.repositories.projections.RoomTypeNameOnly;

@RestController("rest RoomtypeController")
@RequestMapping("/api")
public class RoomtypeController {
	
	@Autowired
	public RoomTypeRepository roomTypeRepository;
	
	/*
	@RequestMapping(value="/roomtypes",method=RequestMethod.GET)
	public List<RoomType> getAll(){
		List<RoomType> roomType = roomTypeRepository.findAll();
		
		return roomType;
	}*/
	@CrossOrigin
	@RequestMapping(value="/roomtypes/{id}",method=RequestMethod.GET)
	public Collection<RoomTypeNameOnly> getAll(@PathVariable Long id){
		
		Hotel hotel = new Hotel();
		hotel.setId(id);
		
		
		
		Collection<RoomTypeNameOnly> roomType = roomTypeRepository.findAllByRthotel(hotel);
		
		return roomType;
	}

}
