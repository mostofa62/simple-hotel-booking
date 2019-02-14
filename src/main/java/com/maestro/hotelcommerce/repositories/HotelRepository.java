package com.maestro.hotelcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maestro.hotelcommerce.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Long>{

}
