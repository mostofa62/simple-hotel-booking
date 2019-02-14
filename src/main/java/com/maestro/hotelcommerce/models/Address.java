package com.maestro.hotelcommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="addresses")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="street_1",length=100)
	@NotBlank
	@NotNull
	private String streetOne;
	
	@Column(name="street_2",length=100)	
	private String streetTwe;
	
	
	@Column(name="zip_code")
	@NotNull
	private short zipCode;
	
	@OneToOne(mappedBy="address")
	private Customer customer;
	
	
}
