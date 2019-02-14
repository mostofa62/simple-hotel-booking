package com.maestro.hotelcommerce.models.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.maestro.hotelcommerce.models.Hotel;
import com.maestro.hotelcommerce.models.validators.annotations.ManyToOneRequired;

public class ManyToOneRequiredHotel implements ConstraintValidator<ManyToOneRequired, Hotel> {

	@Override
	public void initialize(ManyToOneRequired arg0) {}
	
	@Override
	public boolean isValid(Hotel hotel, ConstraintValidatorContext ctx) {
		
		if(hotel.getId() == null) {
			return false;
		}
		
		
		return true;
	}
}