package com.maestro.hotelcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maestro.hotelcommerce.models.cores.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
