package com.maestro.hotelcommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="addresses")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	@Column(name="alias_name", length=100)
	@NotBlank
	private String name;
	
	@Column(name="street_1",length=100)
	@NotBlank
	private String streetOne;
	
	@Column(name="street_2",length=100)	
	private String streetTwe;
	
	
	@Column(name="zip_code")	
	@Min(1)
	@NotNull
	private short zipCode;
	
	@OneToOne(mappedBy="address")
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetOne() {
		return streetOne;
	}

	public void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}

	public String getStreetTwe() {
		return streetTwe;
	}

	public void setStreetTwe(String streetTwe) {
		this.streetTwe = streetTwe;
	}

	public short getZipCode() {
		return zipCode;
	}

	public void setZipCode(short zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
