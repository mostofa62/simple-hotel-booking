package com.maestro.hotelcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maestro.hotelcommerce.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
