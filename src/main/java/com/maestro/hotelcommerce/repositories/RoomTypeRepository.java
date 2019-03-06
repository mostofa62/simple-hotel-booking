package com.maestro.hotelcommerce.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maestro.hotelcommerce.models.Hotel;
import com.maestro.hotelcommerce.models.RoomType;
import com.maestro.hotelcommerce.repositories.projections.RoomTypeNameOnly;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

	Collection<RoomTypeNameOnly> findAllByRthotel(Hotel hotel);
	
		
}
