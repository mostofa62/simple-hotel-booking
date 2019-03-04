package com.maestro.hotelcommerce.repositories.rest;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Service;

import com.maestro.hotelcommerce.models.Customer;

@Service("customerRestRepository")
public interface CustomerRepository extends DataTablesRepository<Customer, Long> {

}
